package cash.pai.lucky.web;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.entity.UserEntity;
import cash.pai.lucky.param.LoginParam;
import cash.pai.lucky.param.RegisterParam;
import cash.pai.lucky.param.UserParam;
import cash.pai.lucky.service.MailService;
import cash.pai.lucky.service.UserAssetService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "用户信息")
@RestController
@RequestMapping("user/asset")
@Slf4j
public class UserAssetController {
    @Autowired
    UserAssetService userAssetService;


    @Autowired
    MailService mailService;


    @ApiOperation(value = "根据Id查找用户", nickname = "ldw")
    @PostMapping("findById")
    @ResponseBody
    public Result findById(@RequestBody @Valid UserParam userParam) {
        Result result = Result.fail();
        String userId = userParam.getUserId();
        if (StringUtils.isEmpty(userId)) {
            result.setMsg("userId 不能为空");
        } else {

            UserEntity user = userAssetService.findById(userId);
            result = Result.of(user);
        }
        return result;
    }

    /**
     * 注册新用户  同时发送一封激活邮件
     * 注册的时候，前端把密码传过来（密文），
     *
     * @return
     */
    @ApiOperation(value = "注册新用户", nickname = "ldw")
    @PostMapping("register")
    @ResponseBody
    public Result register(@RequestBody @Valid RegisterParam registerParam, BindingResult bindingResult) {
        Result result = Result.fail();
        try {
            if (bindingResult.hasErrors()) {
                result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            } else {
                result = userAssetService.register(registerParam);
            }
        } catch (Exception e) {
            log.error("注册新用户接口异常", e);
        }
        return result;
    }

    /**
     * 激活新用户
     *
     * @return
     */
    @ApiOperation(value = "激活新用户", nickname = "ldw")
    @RequestMapping(value = "checkCode", method = RequestMethod.GET)
    @ResponseBody
    public Result checkCode(@RequestParam("checkCode") String checkCode) {
        Result result = userAssetService.checkCode(checkCode);
        return result;
    }

    /**
     * 登录接口
     * 主要是校验用户名userName和  密码password是否匹配
     *
     * @return
     */
    @ApiOperation(value = "登录")
    @RequestMapping(value = "login")
    @ResponseBody
    public Result login(@RequestBody @Valid LoginParam loginParam) {
        Result result = userAssetService.login(loginParam);
        return result;
    }


}
