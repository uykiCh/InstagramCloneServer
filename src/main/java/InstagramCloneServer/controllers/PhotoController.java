package InstagramCloneServer.controllers;

import InstagramCloneServer.models.comment.Comment;
import InstagramCloneServer.models.comment.CommentDao;
import InstagramCloneServer.models.likes.Likes;
import InstagramCloneServer.models.likes.LikesDao;
import InstagramCloneServer.models.photo_comments.PhotoComment;
import InstagramCloneServer.models.photos.Photos;
import InstagramCloneServer.models.photos.PhotosDao;
import InstagramCloneServer.models.photo_comments.PhotoCommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class PhotoController {

    @Autowired
    PhotosDao photosDao;

    @Autowired
    PhotoCommentDao photoCommentsDao;

    @Autowired
    CommentDao commentsDao;

    @Autowired
    LikesDao likesDao;

    @RequestMapping(path = "/photos/add")
    @ResponseBody
    boolean addPost(@RequestParam(value = "user_id") Long user_id,
                    @RequestParam(value = "caption", required = false) String caption,
                    @RequestParam(value = "latitude", required = false) Float latitude,
                    @RequestParam(value = "longitude", required = false) Float longitude,
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

    @RequestMapping(path = "/photos/{id}/{interaction}")
    @ResponseBody
    Object interaction(@PathVariable(value = "id") Long photoId,
                       @PathVariable(value = "interaction") String interaction,
                       @RequestParam(value = "text", required = false) String text,
                       @RequestParam(value = "comment_id", required = false) Long commentId,
                       @RequestParam(value = "user_id", required = false) Long userId) throws Exception {

        if (interaction.equals("update")) {

            try {

                photosDao.updateData(photoId, text, (new Date((new java.util.Date()).getTime())));


            } catch (Exception e) {

                return false;

            }

            return true;

        } else if (interaction.equals("delete")) {

            try {

                photosDao.deleteById(photoId);

            } catch (Exception e) {

                return false;

            }

            return true;

        } else if (interaction.equals("getComments")) {

            try {

                return photoCommentsDao.queryFirst10ByPhotoIdOrderByCommentIdDesc(photoId);

            } catch (Exception e) {

                return e.getMessage();

            }

        } else if (interaction.equals("addComment")) {

            try {

                PhotoComment photoComment = new PhotoComment(photoId);

                photoCommentsDao.save(photoComment);

                commentsDao.save(new Comment(photoComment.getCommentId(), text));

                return true;

            } catch (Exception e) {

                return false;

            }

        } else if (interaction.equals("deleteComment")) {

            try {

                photoCommentsDao.deleteById(commentId);

                commentsDao.deleteById(commentId);

                return true;

            } catch (Exception e) {

                return e.getMessage();

            }

        } else if (interaction.equals("addLike")) {

            try {

                likesDao.save(new Likes(photoId, userId));

            } catch (Exception e) {

                return false;

            }

            return true;

        } else /*if (interaction.equals("deleteLike")) */{

            try {

                likesDao.deleteByPhotoIdAndUserId(photoId, userId);

            } catch (Exception e) {

                return false;

            }

            return true;

        }

    }

}
