//package cash.pai.lucky.service.impl;
//
//import cash.pai.lucky.common.dynamicquery.DynamicQuery;
//import cash.pai.lucky.common.entity.Role;
//import cash.pai.lucky.common.entity.Seckill;
//import cash.pai.lucky.common.entity.User;
//import cash.pai.lucky.member.Member;
//import cash.pai.lucky.repository.RoleRepository;
//import cash.pai.lucky.repository.SeckillRepository;
//import cash.pai.lucky.repository.UserRepository;
//import cash.pai.lucky.service.IMemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service("memberService")
//public class MemberServiceImpl implements IMemberService {
//
//    @Autowired
//    private DynamicQuery dynamicQuery;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = getUserByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("账户不存在!");
//        }
//        Member member = new Member();
//        member.setUser(user);
//        member.setRoles(getUserRolesByUid(user.getId()));
//        return member;
//    }
//
//    private List<Role> getUserRolesByUid(long uid) {
//        return roleRepository.findRoleByUserID(uid);
//    }
//
//    private User getUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//}
