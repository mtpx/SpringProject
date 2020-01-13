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

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO; }

    @GetMapping(value = "/user")
    public List<User> getUsersQuery(){
        return userService.findAllQuery();
    }

    @GetMapping(value = "/user/{id}")
    public User getUserQuery(@PathVariable int id){
        return userService.findByIdQuery(id);
    }

    @PostMapping(value = "/user", consumes = APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody User user){
        userDAO.save(user);
    }

    @DeleteMapping(value = "/user/{id}")
    public void deleteUser(@PathVariable int id){
        userDAO.deleteById(id);
    }

    @DeleteMapping(value = "/user")
    public void deleteAllUsers(){
        userDAO.deleteAll();
    }

    @PostMapping(value = "/login", consumes = APPLICATION_JSON_VALUE)
    public int checkUser(@RequestBody ObjectNode objectNode){
        String email = objectNode.get("email").asText();
        String password = objectNode.get("password").asText();
        return userService.checkUser(email, password);
    }


    //    @GetMapping(value = "/user")
//    public @ResponseBody Iterable<User> getUsers() {
//        return userDAO.findAll();
//    }
//
//    @GetMapping(value = "/user/{id}")
//    public @ResponseBody Optional<User> getUserById(@PathVariable int id) {
//        return userDAO.findById(id);
//    }
}
