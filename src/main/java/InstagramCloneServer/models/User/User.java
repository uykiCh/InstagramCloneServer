package InstagramCloneServer.models.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users", schema = "instagramclone")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @NotNull
    @Column(name = "login", nullable = false, length = 20)
    private String login;

    @Column(name = "about")
    private String about;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "image")
    private String image;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public User(@NotNull String login) {
        this.login = login;
    }

    public User(long id, @NotNull String login, String about, String fullname) {
        this.id = id;
        this.login = login;
        this.about = about;
        this.fullname = fullname;
    }

    public User(long id, @NotNull String login, String image) {
        this.id = id;
        this.login = login;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "\nLogin: " + getLogin() + "\nFullname: " + getFullname() + "\nAbout: " + getAbout();
    }
}
