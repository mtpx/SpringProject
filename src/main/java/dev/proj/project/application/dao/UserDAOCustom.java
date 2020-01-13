package dev.proj.project.application.dao;
import dev.proj.project.application.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface UserDAOCustom {
    User findByIdQuery(int userId);
    List<User> findAllQuery();
    List<User> checkUser(String mail, String password);
}


