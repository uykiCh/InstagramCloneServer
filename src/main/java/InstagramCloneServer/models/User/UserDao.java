package InstagramCloneServer.models.User;

import InstagramCloneServer.models.User.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface UserDao extends CrudRepository<User, Long> {

    @Modifying
    @Query(value = "SELECT * FROM users u WHERE u.login IN (:login)", nativeQuery = true)
    List<User> usersList(@Param("login") String[] login);

    @Modifying
    @Query(value = "UPDATE Users u SET u.fullname = :fullname, u.about = :about, u.image = :image WHERE u.id = :id",
            nativeQuery = true)
    void updateSettings(@Param("id") long id, @Param("fullname") String fullname,
                        @Param("about") String about, @Param("image") String image);

}
