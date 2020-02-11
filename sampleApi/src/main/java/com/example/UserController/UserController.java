package com.example.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserService.UserService;
import com.example.entity.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.findUsers();
    }

    @RequestMapping(method=RequestMethod.GET, value="{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.findUser(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    public User createUser(@Validated @RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        user.setId(id);
        return userService.save(user);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }

}
