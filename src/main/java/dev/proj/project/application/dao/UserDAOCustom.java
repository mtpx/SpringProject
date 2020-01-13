package dev.proj.project.application.dao;
import dev.proj.project.application.model.User;
import java.util.List;

public interface UserDAOCustom {
    User findByIdQuery(int userId);
    List<User> findAllQuery();
    List<User> checkUser(String mail, String password);
}


