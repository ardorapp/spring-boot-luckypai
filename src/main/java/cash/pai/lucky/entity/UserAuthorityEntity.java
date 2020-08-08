package cash.pai.lucky.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserAuthorityEntity {
    private String userAuthorityId;//用户权限表id
    private String userId;//用户id
    private String authorityId;//权限id
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
}
