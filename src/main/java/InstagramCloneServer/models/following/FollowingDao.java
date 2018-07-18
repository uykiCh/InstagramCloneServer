package InstagramCloneServer.models.following;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface FollowingDao extends CrudRepository<Following, Long> {

    long countByFollowerId(long followerId);

    long countByUserId(long userId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Following WHERE user_id = ?1 AND follower_id = ?2",
            nativeQuery = true)
    int delete(long user_id, long follower_id);

}
