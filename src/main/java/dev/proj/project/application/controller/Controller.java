package dev.proj.project.application.controller;

import dev.proj.project.application.dao.UserDAO;
import dev.proj.project.application.dao.UserDAOCustom;
import dev.proj.project.application.model.User;
import dev.proj.project.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDAO userDAO;

    public Controller(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping(value = "/")
    public String hello() {
        return "Hello world";
    }

    @GetMapping(value = "/users")
    public Iterable<User> getUsers() {
        return userDAO.findAll();
    }

    @GetMapping(value = "/users/{userId}")
    public Optional<User> getUserById(@PathVariable int userId) {
        return userDAO.findById(userId);
    }

    @GetMapping(value = "/usersQuery")
    public List<User> getUsersQuery(){
        return userService.findAllQuery();
    }

    @GetMapping(value = "/usersQuery/{userId}")
    public User getUserQuery(@PathVariable int userId){
        return userService.findByIdQuery(userId);
    }

    @PostMapping(value = "/users", consumes = APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody User user){
        userDAO.save(user);
    }

    @DeleteMapping(value = "/users/{userId}")
    public void deleteUser(@PathVariable int userId){
        userDAO.deleteById(userId);
    }

    @DeleteMapping(value = "/users")
    public void deleteAllUsers(){
        userDAO.deleteAll();
    }
}
