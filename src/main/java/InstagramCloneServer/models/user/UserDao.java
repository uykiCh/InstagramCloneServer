package InstagramCloneServer.models.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao extends CrudRepository<User, Long> {

    User findByUserId(Long id);

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM users u WHERE u.login IN (:login)", nativeQuery = true)
    List<User> usersList(@Param("login") String[] login);

}
