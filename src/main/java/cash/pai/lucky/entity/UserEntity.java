package cash.pai.lucky.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
public class UserEntity {

    private String userId;//用户id

    private String loginName;//登录名

    private String userName;//用户名称

    private String password;//登录密码

    private String valid="N";//是否已经激活，Y/N

    private String limitedIp;//限制允许登录的IP集合


    private String phone;//
    private String email;//
    private String sex;//
    private String realName;//
    private String idCard;//

    private Date expiredTime;//账号失效时间，超过时间将不能登录系统

    private Date lastChangePwdTime=new Date();//最近修改密码时间，超出时间间隔，提示用户修改密码

    private String limitMultiLogin="N";//是否允许账号同一个时刻多人在线，Y/N

    private Date createTime;//创建时间

    private Date updateTime;//修改时间

}
