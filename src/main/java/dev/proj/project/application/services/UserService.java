package dev.proj.project.application.services;

import dev.proj.project.application.model.User;
import java.util.List;

public interface UserService {
    User findByIdQuery(int userId);
    List<User> findAllQuery();
    boolean checkUser(String mail, String password);
}
