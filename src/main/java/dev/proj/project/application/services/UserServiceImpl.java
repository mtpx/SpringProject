package dev.proj.project.application.services;

import dev.proj.project.application.dao.*;
import dev.proj.project.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public User findByIdQuery(int userId) {
        return userDAO.findByIdQuery(userId);
    }

    @Override
    public List<User> findAllQuery() {
        return userDAO.findAllQuery();
    }
}
