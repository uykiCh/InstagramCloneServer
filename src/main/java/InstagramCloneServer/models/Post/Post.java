package InstagramCloneServer.models.Post;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "posts", schema = "instagramclone")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    long id;

    @Column(name = "iduser")
    long iduser;

    @Column(name = "image")
    String image;

    @Column(name = "description")
    String description;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "timestamp")
    Date timestamp;

    public Post() {
    }

    public Post(long iduser, String image, String description, Date timestamp) {
        this.iduser = iduser;
        this.image = image;
        this.description = description;
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
