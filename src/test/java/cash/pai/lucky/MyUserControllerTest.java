package cash.pai.lucky;

import cash.pai.lucky.param.UserParam;
import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * 测试用例，controller层，可测试所有controller
 *
 * @author ldw
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyUserControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * 获取最新app信息
     */
    @Test
    public void findById() throws Exception {
        RequestBuilder request = null;
        //构造请求

        UserParam userParam=new UserParam();
        userParam.setUserId("2");
        String requestJson = JSONObject.toJSONString(userParam);

        request = post("/front/user/findById")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson.getBytes()) ;
        //执行请求
        mockMvc.perform(request)
                .andExpect(status().isOk())//返回HTTP状态为200
                .andDo(print());//打印结果

    }

    /**
     * 获取最新app信息
     */
    @Test
    public void register() throws Exception {
        RequestBuilder request = null;
        //构造请求
        UserParam userParam=new UserParam();
        String requestJson = JSONObject.toJSONString(userParam);

        request = post("/front/user/register")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson.getBytes()) ;
        //执行请求
        mockMvc.perform(request)
                .andExpect(status().isOk())//返回HTTP状态为200
                .andDo(print());//打印结果
        //.andReturn();//想要返回结果，使用此方法

    }

    /**
     * 获取最新app信息
     */
  /*  @Test
    public void find() throws Exception {
        RequestBuilder request = null;
        //构造请求
        UserParam userParam=new UserParam();
        userParam.setUserId("1");
        String requestJson = JSONObject.toJSONString(userParam);

        request = post("/front/user/find")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson.getBytes())
                .param("userId", "1");
        //执行请求
        mockMvc.perform(request)
                .andExpect(status().isOk())//返回HTTP状态为200
                .andDo(print());//打印结果
        //.andReturn();//想要返回结果，使用此方法

    }*/



}