package dev.proj.project.application.controller;

import dev.proj.project.application.dao.HomeDAO;
import dev.proj.project.application.model.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class HomeController {

    @Autowired
    private HomeDAO homeDAO;

    public HomeController(HomeDAO homeDAO) {
        this.homeDAO = homeDAO; }

    @GetMapping(value = "/home")
    public List<Home> getHomes(){
        return homeDAO.findAll();
    }

    @GetMapping(value = "/home/{id}")
    public Optional<Home> getHome(@PathVariable int id){
        return homeDAO.findById(id);
    }

    @PostMapping(value = "/home", consumes = APPLICATION_JSON_VALUE)
    public void addHome(@RequestBody Home home){
        homeDAO.save(home);
    }


//    @DeleteMapping(value = "/user/{id}")
//    public void deleteUser(@PathVariable int id){
//        userDAO.deleteById(id);
//    }

}
