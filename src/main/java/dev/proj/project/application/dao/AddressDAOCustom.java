package dev.proj.project.application.dao;
import dev.proj.project.application.model.Address;
import dev.proj.project.application.model.User;

import java.util.List;

public interface AddressDAOCustom {
    List<Address> findAll();
    List<Address> findAddressesByUserId(int userId);
}


