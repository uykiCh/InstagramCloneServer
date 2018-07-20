package InstagramCloneServer.controllers;

import InstagramCloneServer.models.following.Following;
import InstagramCloneServer.models.following.FollowingDao;
import InstagramCloneServer.models.likes.LikesDao;
import InstagramCloneServer.models.photos.PhotosDao;
import InstagramCloneServer.models.user.User;
import InstagramCloneServer.models.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    FollowingDao followingDao;

    @Autowired
    PhotosDao photosDao;

    @RequestMapping(path = "/user/{id}/settings")
    @ResponseBody
    boolean setSettings(@PathVariable("id") Long id,
                        @RequestParam(value = "first_name", required = false) String first_name,
                        @RequestParam(value = "last_name", required = false) String last_name,
                        @RequestParam(value = "about", required = false) String about,
                        @RequestParam(value = "image", required = false) String image) throws Exception {

        try {

            User user = userDao.findByUserId(id);

            if (first_name != null) {
                user.setFirst_name(first_name);
            }
            if (last_name != null) {
                user.setLast_name(last_name);
            }
            if (about != null) {
                user.setAbout(about);
            }
            if (image != null) {
                user.setImage(image);
            }
            userDao.save(user);

        } catch (Exception e) {

            return false;

        }

        return true;

    }

    @RequestMapping(path = "/user/{user_id}/{interaction}")
    @ResponseBody
    Object interactions(@PathVariable(value = "user_id") Long userId,
                        @PathVariable(value = "interaction") String paramInteraction,
                        @RequestParam(value = "follower_id", required = false) Long followerId) throws Exception {

        if (paramInteraction.equals("getFollowersCount")) {

            return followingDao.countByFollowerId(userId);

        } else if (paramInteraction.equals("getFollowingCount")) {

            return followingDao.countByUserId(userId);

        } else if (paramInteraction.equals("addSubscription")) {

            try {

                followingDao.save(new Following(followerId, userId));

            } catch (Exception e) {

                return false;

            }

            return true;

        } else if (paramInteraction.equals("deleteSubscription")) {

            try {

                followingDao.delete(followerId, userId);

            } catch (Exception e) {

                return false;

            }

            return true;

        } else if (paramInteraction.equals("getUser")) {

            try {

                return userDao.findById(userId);

            } catch (Exception e) {

                return null;

            }
        } else /*if (paramInteraction.equals("getPhotosBySubscription"))*/ {

            try {

                List<Following> subscriptionsFullList = followingDao.findByFollowerId(userId);
                List<Long> subscriptionsList = new ArrayList<>();
                subscriptionsFullList.forEach(v -> subscriptionsList.add(v.getUserId()));

                System.out.println("List is ");
                subscriptionsList.forEach(System.out::println);

                return photosDao.queryFirst10ByUserId(subscriptionsList);

            } catch (Exception e) {

                return e.getMessage();

            }

        }

    }

    @RequestMapping(path = "/user/create")
    @ResponseBody
    boolean createUser(@RequestParam(value = "login") String login) throws Exception {

        try {

            userDao.save(new User(login));

        } catch (Exception e) {

            return false;

        }

        return true;

    }

    @RequestMapping(path = "/user/find", method = RequestMethod.GET)
    @ResponseBody
    List<User> findByLogin(@RequestParam(value = "login") String[] login) throws Exception {

        return userDao.usersList(login);

    }

}
