package InstagramCloneServer.controllers;

import InstagramCloneServer.models.following.Following;
import InstagramCloneServer.models.following.FollowingDao;
import InstagramCloneServer.models.user.User;
import InstagramCloneServer.models.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    FollowingDao followingDao;

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
    Object interactions(@PathVariable(value = "user_id") Long user_id,
                        @PathVariable(value = "interaction") String paramInteraction,
                        @RequestParam(value = "follower_id", required = false) Long follower_id) throws Exception {

        if (paramInteraction.equals("getFollowersCount")) {

            return followingDao.countByFollowerId(user_id);

        } else if (paramInteraction.equals("getFollowingCount")) {

            return followingDao.countByUserId(user_id);

        } else if (paramInteraction.equals("addSubscription")) {

            try {

                followingDao.save(new Following(user_id, follower_id));

            } catch (Exception e) {

                return false;

            }


            return true;

        } else if (paramInteraction.equals("deleteSubscription")) {

            try {

                followingDao.delete(user_id, follower_id);

            } catch (Exception e) {

                return false;

            }

            return true;

        } else /*if (paramInteraction.equals("getUser"))*/ {

            try {

                return userDao.findById(user_id);

            } catch (Exception e) {

                return null;

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
