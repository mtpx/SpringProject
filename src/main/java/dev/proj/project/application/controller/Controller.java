package dev.proj.project.application.controller;

import dev.proj.project.application.dao.UserDAO;
import dev.proj.project.application.model.User;
import dev.proj.project.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDAO userDAO;

    public Controller(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "Hello world";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Iterable<User> getUsers() {
        return userDAO.findAll();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public Optional<User> getUserById(@PathVariable int userId) {
        return userDAO.findById(userId);
    }

    @RequestMapping(value = "/usersQuery", method = RequestMethod.GET)
    public List<User> getUsersQuery(){
        return userService.findAllQuery();
    }

    @RequestMapping(value = "/usersQuery/{userId}", method = RequestMethod.GET)
    public User getUserQuery(@PathVariable int userId){
        return userService.findByIdQuery(userId);
    }

//    @RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
//    public void addUser(@RequestBody User user){
//        userService.saveUser(user);
//    }
}
