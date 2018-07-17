package InstagramCloneServer.models.subscription;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionDao extends CrudRepository<Subscription, Long> {

    @Modifying
    @Query(value = "DELETE FROM subscriptions WHERE id = ?1 AND idsub = ?2" , nativeQuery = true)
    int delete(long id, long idsub);

    @Modifying
    @Query(value = "INSERT INTO subscriptions (id, idsub) VALUES (?1, ?2)", nativeQuery = true)
    int add(long id, long idsub);

    /*@Modifying
    @Query(value = "SELECT COUNT(*) FROM Users WHERE idSub = ?1", nativeQuery = true)
    int getSubscriptionCount(long idSub);*/

    long countById(long id);

    long countByIdsub(long idsub);

}
