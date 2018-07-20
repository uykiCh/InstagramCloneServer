package InstagramCloneServer.models.likes;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikesDao extends CrudRepository<Likes, Long> {

    void deleteByPhotoIdAndUserId(Long photo_id, Long user_id);

    Long findByPhotoIdAndUserId(Long photo_id, Long user_id);

}
