package dev.proj.project.application.controller;

import dev.proj.project.application.dao.AddressDAO;
import dev.proj.project.application.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class AddressController {

    @Autowired
    private AddressDAO addressDAO;

    public AddressController(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @PostMapping(value = "/address", consumes = APPLICATION_JSON_VALUE)
    public void addAddress(@RequestBody Address address){
        addressDAO.save(address);
    }

    @DeleteMapping(value = "/address/{id}")
    public void deleteAddress(@PathVariable int id){
        addressDAO.deleteById(id);
    }


}
