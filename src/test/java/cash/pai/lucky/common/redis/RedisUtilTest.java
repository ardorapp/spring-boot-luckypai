package cash.pai.lucky.common.redis;

import cash.pai.lucky.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class RedisUtilTest extends BaseTest {

    @Autowired
    private RedisUtil redisUtil;


    @Test
    public void cacheValue() {
        redisUtil.cacheValue("ldw", "dd");

    }

    @Test
    public void cacheValue1() {
        redisUtil.cacheValue("ldw", "dd",50, TimeUnit.SECONDS);
    }

    @Test
    public void cacheValue2() {
    }

    @Test
    public void containsValueKey() {
    }

    @Test
    public void getValue() {
        System.out.println( redisUtil.getValue("aa")+"=======================");
    }

    @Test
    public void removeValue() {
    }

    @Test
    public void incr() {
    }

    @Test
    public void decr() {
        String str = MessageFormat.format("我是{0},我来自{1},今年{2}岁", "中国人", "北京", "22");
        System.out.println(str);
    }
}