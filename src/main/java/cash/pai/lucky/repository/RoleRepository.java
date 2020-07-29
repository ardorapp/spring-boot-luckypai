//package cash.pai.lucky.repository;
//
//import cash.pai.lucky.common.entity.Role;
//import cash.pai.lucky.common.entity.Seckill;
//import cash.pai.lucky.common.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface RoleRepository extends JpaRepository<Role, Long> {
//
//    @Query(value = "select * from role r,user_role ur where r.id=ur.rid and ur.uid = ?1", nativeQuery = true)
//    List<Role> findRoleByUserID(long userID);
//}
