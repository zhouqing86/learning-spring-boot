package wendll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wendll.mapper.UserMapper;
import wendll.model.User;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
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