package InstagramCloneServer.controllers;

import InstagramCloneServer.models.following.Following;
import InstagramCloneServer.models.following.FollowingDao;
import InstagramCloneServer.models.user.User;
import InstagramCloneServer.models.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    FollowingDao followingDao;

    @RequestMapping(path = "/user/{id}/settings")
    @ResponseBody
    void setSettings(@PathVariable("id") long id,
                     @RequestParam(value = "first_name") String first_name,
                     @RequestParam(value = "last_name") String last_name,
                     @RequestParam(value = "about") String about,
                     @RequestParam(value = "image") String image) throws Exception {

        userDao.updateSettings(id, first_name, last_name, about, image);

    }


    @RequestMapping(path = "/user/find", method = RequestMethod.GET)
    @ResponseBody
    List<User> findByLogin(@RequestParam(value = "login") String[] login) throws Exception {

        return userDao.usersList(login);

    }

    @RequestMapping(path = "/user/{user_id}")
    @ResponseBody
    Object interactions(@PathVariable(value = "user_id") long user_id,
                        @RequestParam(value = "interaction") String paramInteraction,
                        @RequestParam(value = "follower_id", required = false) Long follower_id) throws Exception {

        if (paramInteraction.equals("getFollowersCount")) {

            return followingDao.countByFollowerId(user_id);

        } else if (paramInteraction.equals("getFollowingCount")) {

            return followingDao.countByUserId(user_id);

        } else if (paramInteraction.equals("addSubscription")){

            try {

                followingDao.save(new Following(user_id, follower_id));

            } catch (Exception e) {

                return false;

            }


            return true;

        } else if (paramInteraction.equals("deleteSubscription")){

            try {

                followingDao.delete(user_id, follower_id);

            } catch (Exception e) {

                return false;

            }

            return true;

        } else /*if (paramInteraction.equals("getUser"))*/{

            try {

                return userDao.findById(user_id);

            } catch (Exception e) {

                return null;

            }
        }

    }

    @RequestMapping(path = "/user/create", method = RequestMethod.POST)
    @ResponseBody
    void createUser(@RequestParam(value = "login") String login) throws Exception {

        userDao.save(new User(login));

    }

}
