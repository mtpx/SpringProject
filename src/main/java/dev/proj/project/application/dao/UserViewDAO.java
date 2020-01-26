package dev.proj.project.application.dao;
import dev.proj.project.application.model.UserView;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface UserViewDAO extends CrudRepository<UserView,Integer>, UserViewDAOCustom {
    List<UserView> findByUserId(int user_id);
    List<UserView> findAll();
    List<UserView> findByStreetAndCity(Optional<String> street, Optional<String> city);
    //List<UserView> findByStreetAndCityAndHouseAndFlatAndCode(String street, String city, String house, String flat, String code);
}

