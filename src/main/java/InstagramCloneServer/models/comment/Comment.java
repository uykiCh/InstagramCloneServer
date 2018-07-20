package InstagramCloneServer.models.comment;

import javax.persistence.*;

@Entity
@Table(name = "comments", schema = "instagramclone")
public class Comment {

    @Id
    @Column(name = "comment_id")
    Long commentId;

    @Column(name = "comment")
    String commentText;

    public Comment() {
    }

    public Comment(Long commentId, String commentText) {
        this.commentId = commentId;
        this.commentText = commentText;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
