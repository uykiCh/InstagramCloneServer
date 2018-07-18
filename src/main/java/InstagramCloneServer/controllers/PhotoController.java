package InstagramCloneServer.controllers;

import InstagramCloneServer.models.photos.Photos;
import InstagramCloneServer.models.photos.PhotosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.Optional;

@Controller
public class PhotoController {

    @Autowired
    PhotosDao photosDao;

    @RequestMapping(path = "/photos/add")
    @ResponseBody
    boolean addPost(@RequestParam(value = "user_id") long user_id,
                    @RequestParam(value = "caption") String caption,
                    @RequestParam(value = "latitude") float latitude,
                    @RequestParam(value = "longitude") float longitude,
                    @RequestParam(value = "image_path") String image_path,
                    @RequestParam(value = "date_created") Date date_created,
                    @RequestParam(value = "date_updated") Date date_updated) {

        try {

            photosDao.save(new Photos(user_id, caption, latitude, longitude, image_path, date_created, date_updated));

        } catch (Exception e) {

            return false;

        }

        return true;
    }

    @RequestMapping(path = "/photos/{id}")
    @ResponseBody
    Optional<Object> getPost(@PathVariable(value = "id") long photo_id) throws Exception {

        try {

            return Optional.ofNullable(photosDao.findByPhotoId(photo_id));

        } catch (Exception e) {

            return Optional.empty();

        }

    }

    @RequestMapping(path = "/photos/delete/{id}")
    @ResponseBody
    boolean deletePhotos(@PathVariable(value = "id") long photo_id) throws Exception {

        try {

            photosDao.deleteById(photo_id);

        } catch (Exception e) {

            return false;

        }

        return true;

    }

    @RequestMapping(path = "/photos/update/{id}")
    @ResponseBody
    boolean updatePhotos(@PathVariable(value = "id") long photo_id,
                       @RequestParam(value = "caption") String caption,
                       @RequestParam(value = "date_updated") Date date_updated) throws Exception {

        try {

            photosDao.updateData(photo_id, caption, date_updated);

        } catch (Exception e) {

            return false;

        }

        return true;

    }

}
