package cash.pai.lucky;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//又webSocket 要加上SpringBootTest.WebEnvironment.RANDOM_PORT  才行，不然单元测试跑步起来
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {
}
