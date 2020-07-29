//package cash.pai.lucky.web;
//
//
//import cash.pai.lucky.common.entity.Result;
//import cash.pai.lucky.common.redis.RedisUtil;
//import cash.pai.lucky.common.utils.DoubleUtil;
//import cash.pai.lucky.queue.delay.jvm.RedPacketMessage;
//import cash.pai.lucky.queue.delay.jvm.RedPacketQueue;
//import cash.pai.lucky.service.IMemberService;
//import cash.pai.lucky.service.IRedPacketService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
///**
// * 会员账户信息。
// */
//@Api(tags ="会员账户")
//@RestController
//@RequestMapping("/member")
//public class MemberController {
//
//	private final static Logger LOGGER = LoggerFactory.getLogger(MemberController.class);
//
//	@Autowired
//	private RedisUtil redisUtil;
//
//	@Autowired
//	private IMemberService memberService;
//
//    /**
//     * 用户信息。
//     * @param username
//     * @return
//     */
//	@ApiOperation(value="用户信息",nickname="Lucky PAI")
//	@PostMapping("/user")
//	public Result getUserInfo(String username){
//        UserDetails userDetails;
//	    try {
//            userDetails = memberService.loadUserByUsername(username);
//            LOGGER.info("查询用户信息{}",userDetails);
//        } catch (UsernameNotFoundException e) {
//            return Result.error(e);
//        }
//		return Result.ok(userDetails);
//	}
//}