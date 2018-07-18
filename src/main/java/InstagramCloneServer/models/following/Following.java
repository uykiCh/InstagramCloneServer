package InstagramCloneServer.models.following;

import javax.persistence.*;

@Entity
@Table(name = "following", schema = "instagramclone")
public class Following {

    @Id
    @Column(name = "user_id")

    long userId;

    @Column(name = "follower_id")
    long followerId;

    public Following() {
    }

    public Following(long userId, long followerId) {
        this.userId = userId;
        this.followerId = followerId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(long followerId) {
        this.followerId = followerId;
    }

}
