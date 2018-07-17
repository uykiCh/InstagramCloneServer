package InstagramCloneServer.models.user;

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

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

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

    public User(long id, @NotNull String login, String about, String first_name, String last_name, String image) {
        this.id = id;
        this.login = login;
        this.about = about;
        this.first_name = first_name;
        this.last_name = last_name;
        this.image = image;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
