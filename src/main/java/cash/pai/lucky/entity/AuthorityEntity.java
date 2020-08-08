package cash.pai.lucky.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
public class AuthorityEntity{
    private String authorityId;//权限id
    private String authorityName;//权限名称，ROLE_开头，全大写
    private String authorityContent;//权限内容，可访问的url，多个时用,隔开
    private String authorityRemark;//权限描述
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
}
