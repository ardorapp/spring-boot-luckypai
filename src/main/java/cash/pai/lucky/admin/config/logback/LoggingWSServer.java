package cash.pai.lucky.admin.config.logback;


import cash.pai.lucky.admin.config.websocket.MyEndpointConfigure;
import cash.pai.lucky.admin.util.ErrorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * WebSocket获取实时日志并输出到Web页面
 *
 * 其实就是一点击“实时日志” 标签页时，就打开websocket   然后用多线程独处当前log文件夹下的日志文件，
 * 然后推送到前端页面，完全可以去掉
 *
 */
@Slf4j
@Component
@ServerEndpoint(value = "/websocket/logging", configurator = MyEndpointConfigure.class)
public class LoggingWSServer {

    @Value("${info.app.name}")
    private String applicationName;

    /**
     * 连接集合
     */
    private static Map<String, Session> sessionMap = new ConcurrentHashMap<String, Session>();
    private static Map<String, Integer> lengthMap = new ConcurrentHashMap<String, Integer>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        //添加到集合中
        sessionMap.put(session.getId(), session);
        lengthMap.put(session.getId(), 1);//默认从第一行开始

        //获取日志信息
        new Thread(()->{
            log.info("LoggingWebSocketServer 任务开始");
            boolean first = true;
            BufferedReader reader = null;
            while (sessionMap.get(session.getId()) != null) {
                try {
                    File logFile = getLastLogFile();
                    if (logFile == null) {
                        return;
                    }
                    //日志文件，获取最新的
                    FileReader fileReader = new FileReader(logFile);
                    //字符流
                    reader = new BufferedReader(fileReader);
                    Object[] lines = reader.lines().toArray();
                    //只取从上次之后产生的日志
                    Object[] copyOfRange = Arrays.copyOfRange(lines, lengthMap.get(session.getId()), lines.length);
                    //对日志进行着色，更加美观  PS：注意，这里要根据日志生成规则来操作
                    for (int i = 0; i < copyOfRange.length; i++) {
                        String line = (String) copyOfRange[i];
                        //先转义
                        line = line.replaceAll("&", "&amp;")
                                .replaceAll("<", "&lt;")
                                .replaceAll(">", "&gt;")
                                .replaceAll("\"", "&quot;");

                        //处理等级
                        line = line.replace("DEBUG", "<span style='color: blue;'>DEBUG</span>");
                        line = line.replace("INFO", "<span style='color: green;'>INFO</span>");
                        line = line.replace("WARN", "<span style='color: orange;'>WARN</span>");
                        line = line.replace("ERROR", "<span style='color: red;'>ERROR</span>");

                        //处理类名
                        String[] split = line.split("]");
                        if (split.length >= 2) {
                            String[] split1 = split[1].split("-");
                            if (split1.length >= 2) {
                                line = split[0] + "]" + "<span style='color: #298a8a;'>" + split1[0] + "</span>" + "-" + split1[1];
                            }
                        }

                        // 匹配日期开头加换行，2019-08-12 14:15:04
                        Pattern r = Pattern.compile("[\\d+][\\d+][\\d+][\\d+]-[\\d+][\\d+]-[\\d+][\\d+] [\\d+][\\d+]:[\\d+][\\d+]:[\\d+][\\d+]");
                        Matcher m = r.matcher(line);
                        if (m.find( )) {
                            //找到下标
                            int start = m.start();
                            //插入
                            StringBuilder  sb = new StringBuilder (line);
                            sb.insert(start,"<br/><br/>");
                            line = sb.toString();
                        }

                        copyOfRange[i] = line;
                    }

                    //存储最新一行开始
                    lengthMap.replace(session.getId(), lines.length);

                    //第一次如果太大，截取最新的200行就够了，避免传输的数据太大
                    if(first && copyOfRange.length > 200){
                        copyOfRange = Arrays.copyOfRange(copyOfRange, copyOfRange.length - 200, copyOfRange.length);
                        first = false;
                    }

                    String result = StringUtils.join(copyOfRange, "<br/>");

                    //发送
                    send(session, result);

                    //休眠一秒
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //输出到日志文件中
                    log.error(ErrorUtil.errorInfoToString(e));
                }
            }
            try {
                reader.close();
            } catch (IOException e) {
                //输出到日志文件中
                log.error(ErrorUtil.errorInfoToString(e));
            }
            log.info("LoggingWebSocketServer 任务结束");
        }).start();
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        //从集合中删除
        sessionMap.remove(session.getId());
        lengthMap.remove(session.getId());
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        //输出到日志文件中
        log.error(ErrorUtil.errorInfoToString(error));
    }

    /**
     * 服务器接收到客户端消息时调用的方法
     */
    @OnMessage
    public void onMessage(String message, Session session) {

    }

    /**
     * 封装一个send方法，发送消息到前端
     */
    private void send(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            //输出到日志文件中
            log.error(ErrorUtil.errorInfoToString(e));
        }
    }

    /**
     * 获取最新的日志文件。
     * @return
     */
    private File getLastLogFile() {
        String logDir = System.getProperty("user.dir") + "/log";
        //+ new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/" + applicationName + ".log"
        File file = new File(logDir);
        File[] fs = file.listFiles();
        if (fs == null || fs.length == 0) {
            return null;
        }
        File lastFile = null;
        for (File f : fs) {
            if (lastFile == null) {
                lastFile = f;
            } else {
                lastFile = f.lastModified() > lastFile.lastModified() ? f : lastFile;
            }
        }
        return lastFile;
    }
}
