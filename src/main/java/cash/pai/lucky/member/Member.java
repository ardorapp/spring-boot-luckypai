//package cash.pai.lucky.member;
//
//import cash.pai.lucky.common.entity.Role;
//import cash.pai.lucky.common.entity.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///**
// * 用户信息表
// */
//public class Member implements UserDetails {
//    private User user;
//    private List<Role> roles;
//
//    //获取当前用户对象所具有的所有角色信息
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for (Role role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return authorities;
//    }
//
//    //获取当前对象密码
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    //获取当前对象用户名
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    //判断账户是否过期
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    //判断账户是否被锁
//    @Override
//    public boolean isAccountNonLocked() {
//        return !user.getLocked();
//    }
//
//    //当前账户密码是否过期
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    //判断当前账户是否可用
//    @Override
//    public boolean isEnabled() {
//        return user.getEnabled();
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public List<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<Role> roles) {
//        this.roles = roles;
//    }
//
//    @Override
//    public String toString() {
//        return "Member{" +
//                "user=" + user +
//                ", roles=" + roles +
//                '}';
//    }
//}
