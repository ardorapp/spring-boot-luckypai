package cash.pai.lucky.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value="登录接口接受参数",description="登录接口  ")
public class LoginParam {
    @NotNull
    @NotEmpty(message = "用户名不能为空")
    private String userName;//用户名称

    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty( value = "登录密码  前端传过来的时候就应该是MD5加密后的密文")
    private String password;//登录密码

}
