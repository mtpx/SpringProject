package dev.proj.project.application.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import dev.proj.project.application.dao.UserDAO;
import dev.proj.project.application.model.User;
import dev.proj.project.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDAO userDAO;

    public Controller(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //widoki

    @GetMapping(value = "/login")
    public String userList() {
        return "login";
    }

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/userList")
    public String login() {
        return "userList";
    }

    @GetMapping(value = "/register")
    public String register() {
        return "register";
    }

    //rest

    @GetMapping(value = "/users")
    public @ResponseBody Iterable<User> getUsers() {
        return userDAO.findAll();
    }

    @GetMapping(value = "/users/{userId}")
    public @ResponseBody Optional<User> getUserById(@PathVariable int userId) {
        return userDAO.findById(userId);
    }

    @GetMapping(value = "/usersQuery")
    public @ResponseBody List<User> getUsersQuery(){
        return userService.findAllQuery();
    }

    @GetMapping(value = "/usersQuery/{userId}")
    public @ResponseBody User getUserQuery(@PathVariable int userId){
        return userService.findByIdQuery(userId);
    }

    @PostMapping(value = "/users", consumes = APPLICATION_JSON_VALUE)
    public @ResponseBody void addUser(@RequestBody User user){
        userDAO.save(user);
    }

    @DeleteMapping(value = "/users/{userId}")
    public @ResponseBody void deleteUser(@PathVariable int userId){
        userDAO.deleteById(userId);
    }

    @DeleteMapping(value = "/users")
    public @ResponseBody void deleteAllUsers(){
        userDAO.deleteAll();
    }

    @PostMapping(value = "/login", consumes = APPLICATION_JSON_VALUE)
    public @ResponseBody boolean checkUser(@RequestBody ObjectNode objectNode){
        String email = objectNode.get("email").asText();
        String password = objectNode.get("password").asText();
        return userService.checkUser(email, password);
    }
}
