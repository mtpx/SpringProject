package dev.proj.project.application.dao;
import dev.proj.project.application.model.UserView;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserViewDAO extends CrudRepository<UserView,Integer>, UserViewDAOCustom {
    List<UserView> findByUserId(int user_id);
    List<UserView> findAll();
    List<UserView> findByStreet(String street);
}

