package InstagramCloneServer.models.photos;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface PhotosDao extends CrudRepository<Photos, Long> {

    Photos findByPhotoId(long photoId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Photos p SET p.caption = :caption, p.date_updated = :date_updated WHERE p.photo_id = :photo_id",
            nativeQuery = true)
    void updateData(@Param("photo_id") long photo_id,
                           @Param("caption") String caption,
                           @Param("date_updated") Date date_updated);

    List<Photos> queryFirst10ByUserId(List<Long> subscriptions);



}
