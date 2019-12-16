package dev.proj.project.application.controller;

import dev.proj.project.application.model.User;
import dev.proj.project.application.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class Controller {

    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "Hello world";
    }

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public User register(@RequestBody User users) {
//    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/usersQuery", method = RequestMethod.GET)
    public List<User> getUsersQuery() {
        return userService.getAllUsersQuery();
    }


    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int userId) {
        return userService.findById(userId);
    }

    @RequestMapping(value = "/usersQuery/{userId}", method = RequestMethod.GET)
    public User getUserQuery(@PathVariable int userId) {
        return userService.getUserQuery(userId);
    }
}
