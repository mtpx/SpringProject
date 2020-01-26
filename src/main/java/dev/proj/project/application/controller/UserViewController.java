package dev.proj.project.application.controller;

import dev.proj.project.application.dao.UserViewDAO;
import dev.proj.project.application.model.UserView;
import dev.proj.project.application.services.UserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserViewController {

    @Autowired
    private UserViewDAO userViewDAO;

    @Autowired
    private UserViewService userViewService;

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

    @GetMapping(value = "/userView/{id}/value")
    public int getValueOfHomes(@PathVariable int id){
        return userViewService.getValueOfHomes(id);
    }

    @GetMapping(value = "/userView/{id}/numberOfHomes")
    public int getNumberOfHomes(@PathVariable int id){
        return userViewService.getNumberOfHomes(id);
    }

    @GetMapping(value = "/userView/search")
    public List<UserView> searchByAddress(
                                        @RequestParam(value = "street") Optional<String> street,
                                          @RequestParam(value = "city")Optional<String> city
//                                          @RequestParam(value = "house", required = false)String house,
//                                          @RequestParam(value = "flat", required = false)String flat,
//                                          @RequestParam(value = "code", required = false)String code
                                ){
        return userViewDAO.findByStreetAndCity(street,city);
    }



}
