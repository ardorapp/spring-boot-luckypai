package cash.pai.lucky.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * @Null 被注释的元素必须为null
 * @NotNull 被注释的元素不能为null
 * @AssertTrue 被注释的元素必须为true
 * @AssertFalse 被注释的元素必须为false
 * @Min(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @Max(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @DecimalMin(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @DecimalMax(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @Size(max,min) 被注释的元素的大小必须在指定的范围内。
 * @Digits(integer,fraction) 被注释的元素必须是一个数字，其值必须在可接受的范围内
 * @Past 被注释的元素必须是一个过去的日期
 * @Future 被注释的元素必须是一个将来的日期
 * @Pattern(value) 被注释的元素必须符合指定的正则表达式。
 * @Email 被注释的元素必须是电子邮件地址
 * @Length 被注释的字符串的大小必须在指定的范围内
 * @NotEmpty 被注释的字符串必须非空
 * @Range 被注释的元素必须在合适的范围内
 *
 * 接收注册接口参数
 */
@Data
@ApiModel(value="user对象",description="注册接口 接收对象")
public class RegisterParam {

    @NotNull
    private String userName;//用户名称
    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty( value = "登录密码  前端传过来的时候就应该是MD5加密后的密文")
    private String password;//登录密码

    @ApiModelProperty(value="手机",name="phone" )
    private String phone;//

    @Email
    @NotEmpty(message = "邮箱地址不能为空 ")
    @ApiModelProperty( value = "邮箱地址" ,example="ldw1986hf123@163.com")
    private String email;//

    @NotNull
    @ApiModelProperty(value="性别。1 男 ；2 女",name="sex",example="1")
    private String sex;//

}
