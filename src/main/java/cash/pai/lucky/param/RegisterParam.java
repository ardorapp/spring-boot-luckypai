package cash.pai.lucky.param;

import lombok.Data;

import javax.validation.constraints.Min;
import java.util.Date;


/**
 * 接收注册接口参数
 */
@Data
public class RegisterParam {
    private String userName;//用户名称
    private String password;//登录密码
    private String phone;//
    private String email;//

    private String sex;//
    private String realName;//
    private String idCard;//
}
