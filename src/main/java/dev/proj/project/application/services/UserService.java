package dev.proj.project.application.services;

import dev.proj.project.application.model.User;
import java.util.List;

public interface UserService {
    User findByIdQuery(int id);
    List<User> findAllQuery();
    int checkUser(String mail, String password);
}
