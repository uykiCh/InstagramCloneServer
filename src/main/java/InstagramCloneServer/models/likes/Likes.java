package InstagramCloneServer.models.likes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "likes", schema = "instagramclone")
public class Likes {

    @Id
    @Column(name = "photo_id")
    Long photoId;

    @Column(name = "user_id")
    Long userId;

    public Likes() {
    }

    public Likes(Long photoId, Long userId) {
        this.photoId = photoId;
        this.userId = userId;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
