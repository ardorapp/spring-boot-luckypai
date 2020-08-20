package cash.pai.lucky.common.webSocket;

import cash.pai.lucky.admin.config.websocket.MyEndpointConfigure;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * WebSocket配置
 * 创建者  科帮网
 * 创建时间	2018年5月29日
 */
@Configuration
public class WebSocketConfig {
    /**
     * 如果注释掉，启动虽然没有报错，但是会导致websocket不可用，
     * 但是如果不注释掉，又导致单元测试跑不起来，原因待考
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    /**
     * 支持注入其他类
     */
    @Bean
    public MyEndpointConfigure newMyEndpointConfigure (){
        return new MyEndpointConfigure ();
    }
}
