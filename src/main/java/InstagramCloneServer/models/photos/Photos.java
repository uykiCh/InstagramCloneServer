package InstagramCloneServer.models.photos;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "photos", schema = "instagramclone")
public class Photos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "photo_id", nullable = false)
    long photoId;

    @Column(name = "user_id")
    long user_id;

    @Column(name = "caption")
    String caption;

    @Column(name = "latitude")
    float latitude;

    @Column(name = "longitude")
    float longitude;

    @Column(name = "image_path")
    String image_path;

    @Column(name = "date_created")
    Date date_created;

    @Column(name = "date_updated")
    Date date_updated;

    public Photos() {
    }

    public Photos(long user_id, String caption, float latitude, float longitude, String image_path, Date date_created, Date date_updated) {
        this.user_id = user_id;
        this.caption = caption;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image_path = image_path;
        this.date_created = date_created;
        this.date_updated = date_updated;
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(Date date_updated) {
        this.date_updated = date_updated;
    }
}