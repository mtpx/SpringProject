package dev.proj.project.application.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import dev.proj.project.application.dao.UserDAO;
import dev.proj.project.application.dao.UserViewDAO;
import dev.proj.project.application.model.User;
import dev.proj.project.application.model.UserView;
import dev.proj.project.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class UserViewController {

    @Autowired
    private UserViewDAO userViewDAO;

    public UserViewController(UserViewDAO userViewDAO) {
        this.userViewDAO = userViewDAO; }

    @GetMapping(value = "/userView")
    public Iterable<UserView> getUsersView(){
        return userViewDAO.findAll();
    }

    @GetMapping(value = "/userView/{id}")
    public Iterable<UserView> getUsersViewByUserId(@PathVariable int id){
        return userViewDAO.findByUserId(id);
    }

//    @GetMapping(value = "/userView/{id}")
//    public List<UserView> getUserViewById(@PathVariable int id){
//        return userViewDAO.findByUserId(id);
//    }


}
