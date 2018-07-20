package InstagramCloneServer.models.photo_comments;

import javax.persistence.*;

@Entity
@Table(name = "photos_comments", schema = "instagramclone")
public class PhotoComment {

    @Column(name = "photo_id")
    private Long photoId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    public PhotoComment() {
    }

    public PhotoComment(Long photoId, Long commentId) {
        this.photoId = photoId;
        this.commentId = commentId;
    }

    public PhotoComment(Long photoId) {
        this.photoId = photoId;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
}
