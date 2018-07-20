package InstagramCloneServer.models.comment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CommentDao extends CrudRepository<Comment, Long> {

    Comment findByCommentId(Long commentId);

}
