package InstagramCloneServer.controllers;

import InstagramCloneServer.models.subscription.SubscriptionDao;
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
    private SubscriptionDao subscriptionDao;

    @RequestMapping("/user/{id}/subscriptions")
    @ResponseBody
    long getSubscriptionCount(@RequestParam(value = "id") long id) throws Exception {
        return subscriptionDao.countById(id);
    }

    @RequestMapping("/user/{id}/subscribers")
    @ResponseBody
    long getSubscribersCount(@RequestParam(value = "id") long id) throws Exception {
        return subscriptionDao.countByIdsub(id);
    }

    @RequestMapping(path = "/user/{id}/settings")
    @ResponseBody
    void setSettings(@PathVariable("id") long id,
                     @RequestParam(value = "first_name") String first_name,
                     @RequestParam(value = "last_name") String last_name,
                     @RequestParam(value = "about") String about,
                     @RequestParam(value = "image") String image) throws Exception {

        userDao.updateSettings(id, first_name,last_name , about, image);

    }

    @RequestMapping(path = "/user/create", method = RequestMethod.POST)
    @ResponseBody
    void create(@RequestParam(value = "login") String login) throws Exception {

        User user = new User(login);
        userDao.save(user);

    }


    @RequestMapping(path = "/user/{id}/find", method = RequestMethod.GET)
    @ResponseBody
    List<User> findByLogin(@PathVariable("id") long id,
                                  @RequestParam(value = "login") String[] login) throws Exception{

        return userDao.usersList(login);

    }

    @RequestMapping(path = "user/{id}", method = RequestMethod.GET)
    @ResponseBody
    Optional<User> getUser(@PathVariable("id") long id){
        try {

            return userDao.findById(id);

        }catch (Exception e){
            return Optional.empty();
        }
    }

}
