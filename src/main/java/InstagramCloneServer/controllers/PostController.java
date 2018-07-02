package InstagramCloneServer.controllers;

import InstagramCloneServer.models.Post.Post;
import InstagramCloneServer.models.Post.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostDao postDao;

    @RequestMapping(path = "/post/add")
    @ResponseBody
    boolean addPost(@RequestParam(value = "iduser") long iduser,
                    @RequestParam(value = "image") String image,
                    @RequestParam(value = "description") String description,
                    @RequestParam(value = "timestamp") Date timestamp) {

        try {

            postDao.save(new Post(iduser, image, description, timestamp));

        } catch (Exception e) {

            return false;

        }

        return true;
    }

    @RequestMapping(path = "/post/delete/{id}")
    @ResponseBody
    boolean deletePost(@PathVariable(value = "id") long id) throws Exception {

        try {

            postDao.deleteById(id);

        } catch (Exception e) {

            return false;

        }

        return true;

    }

    @RequestMapping(path = "/post/update/{id}")
    @ResponseBody
    boolean updatePost(@PathVariable(value = "id") long id,
                       @RequestParam(value = "description") String description) throws Exception {

        try {

            postDao.updateDescription(id, description);

        } catch (Exception e) {

            return false;

        }

        return true;

    }

    @RequestMapping(path = "/post/{id}")
    @ResponseBody
    Optional<Post> getPost(@PathVariable(value = "id") long id) throws Exception {

        try {

            return postDao.findById(id);

        } catch (Exception e) {

            return Optional.empty();

        }

    }

}
