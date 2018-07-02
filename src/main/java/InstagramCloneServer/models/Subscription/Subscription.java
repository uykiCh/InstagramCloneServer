package InstagramCloneServer.models.Subscription;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subscriptions", schema = "instagramclone")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "idsub", nullable = false)
    private long idsub;

    public Subscription() {
    }

    public Subscription(long id) {
        this.id = id;
    }

    public Subscription(long id, long idsub) {
        this.id = id;
        this.idsub = idsub;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdsub() {
        return idsub;
    }

    public void setIdsub(long idsub) {
        this.idsub = idsub;
    }
}
