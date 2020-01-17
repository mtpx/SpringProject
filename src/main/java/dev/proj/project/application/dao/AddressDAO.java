package dev.proj.project.application.dao;
import dev.proj.project.application.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressDAO extends CrudRepository<Address,Integer>, AddressDAOCustom {
    List<Address> findByUser_Id(int userId);
    List<Address> findAll();
}

