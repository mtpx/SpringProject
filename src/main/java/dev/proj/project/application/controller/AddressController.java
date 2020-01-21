package dev.proj.project.application.controller;

import dev.proj.project.application.dao.AddressDAO;
import dev.proj.project.application.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class AddressController {

    @Autowired
    private AddressDAO addressDAO;

    public AddressController(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @PostMapping(value = "/address", consumes = APPLICATION_JSON_VALUE)
    public Address addAddress(@RequestBody Address address){
        addressDAO.save(address);
        return address;
    }

    @DeleteMapping(value = "/address/{id}")
    public void deleteAddress(@PathVariable int id){
        addressDAO.deleteById(id);
    }

    @GetMapping(value = "/address/{userId}")
    public List<Address> getAddress(@PathVariable int userId){
        return addressDAO.findByUser_Id(userId);
    }

    @GetMapping(value = "/address")
    public @ResponseBody Iterable<Address> getAddress() {
        return addressDAO.findAll();
    }


}
