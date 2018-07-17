package InstagramCloneServer.controllers;

import InstagramCloneServer.models.subscription.SubscriptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SubscribeController {

    @Autowired
    private SubscriptionDao subscriptionDao;

    @RequestMapping("/subscribe/{id}/add")
    @ResponseBody
    boolean addSub(@PathVariable("id") long id,
                   @RequestParam(value = "idsub") long idsub) throws Exception {

        return subscriptionDao.add(id, idsub) != 0;

    }

    @RequestMapping("/subscribe/{id}/delete")
    @ResponseBody
    boolean deleteSub(@PathVariable("id") long id,
                      @RequestParam(value = "idsub") long idsub) throws Exception {

        return subscriptionDao.delete(id, idsub) != 0;

    }

}
