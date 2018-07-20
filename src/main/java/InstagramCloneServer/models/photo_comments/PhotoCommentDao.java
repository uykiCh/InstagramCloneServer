package InstagramCloneServer.models.photo_comments;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PhotoCommentDao extends CrudRepository<PhotoComment, Long> {

    List<PhotoComment> queryFirst10ByPhotoIdOrderByCommentIdDesc(Long photoId);

}
