package InstagramCloneServer.models.Post;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PostDao extends CrudRepository<Post, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE Posts p SET p.description = :description WHERE p.id = :id",
            nativeQuery = true)
    void updateDescription(@Param("id") long id, @Param("description") String description);

}
