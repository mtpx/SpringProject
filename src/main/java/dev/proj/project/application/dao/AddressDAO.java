package dev.proj.project.application.dao;
import dev.proj.project.application.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDAO extends CrudRepository<Address,Integer>, AddressDAOCustom {
}

