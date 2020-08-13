package cash.pai.lucky.web;

import cash.pai.lucky.admin.common.pojo.Result;
import cash.pai.lucky.entity.UserEntity;
import cash.pai.lucky.param.RegisterParam;
import cash.pai.lucky.param.UserParam;
import cash.pai.lucky.service.RedPackageUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(tags = "用户信息")
@RestController
@RequestMapping("front/user")
public class MyUserController {
    @Autowired
    RedPackageUserService sysUserService;


    @ApiOperation(value = "根据Id查找用户", nickname = "ldw")
    @PostMapping("findById")
    @ResponseBody
    public Result findById(@RequestBody @Valid UserParam userParam) {
        Result result = Result.fail();
        String userId = userParam.getUserId();
        if (StringUtils.isEmpty(userId)) {
            result.setMsg("userId 不能为空");
        } else {
            UserEntity user = sysUserService.findById(userId);
            result = Result.of(user);
        }
        return result;
    }

    /**
     * 注册新用户
     *
     * @return
     */
    @ApiOperation(value = "注册新用户", nickname = "ldw")
    @PostMapping("register")
    @ResponseBody
    public Result register(@RequestBody @Valid RegisterParam registerParam) {
        Result result = sysUserService.register(registerParam);
        return result;
    }

    /**
     * 注册新用户
     *
     * @return
     */
    @ApiOperation(value = "注册新用户", nickname = "ldw")
    @PostMapping("find")
    @ResponseBody
    public Result find(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        UserEntity user = sysUserService.findById(userId);
        Result result = Result.of(user);
        return result;
    }

}
