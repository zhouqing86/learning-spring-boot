package wendll.controllers;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wendll.mapper.UserMapper;
import wendll.model.User;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        PageHelper.startPage(page == null? 1 : page, pageSize == null ? 1 : pageSize);
        List<User> users=userMapper.getAll();
        return users;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        User user=userMapper.getOne(id);
        return user;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void save(User user) {
        userMapper.insert(user);
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
    public void update(User user) {
        userMapper.update(user);
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }

}