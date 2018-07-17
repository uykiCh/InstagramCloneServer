package InstagramCloneServer.models.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<User, Long> {

    @Modifying
    @Query(value = "SELECT * FROM users u WHERE u.login IN (:login)", nativeQuery = true)
    List<User> usersList(@Param("login") String[] login);

    @Modifying
    @Query(value = "UPDATE Users u SET u.first_name = :first_name, u.last_name = :last_name, u.about = :about, u.image = :image WHERE u.id = :id",
            nativeQuery = true)
    void updateSettings(@Param("id") long id,
                        @Param("first_name") String first_name,
                        @Param("last_name") String last_name,
                        @Param("about") String about,
                        @Param("image") String image);

}
