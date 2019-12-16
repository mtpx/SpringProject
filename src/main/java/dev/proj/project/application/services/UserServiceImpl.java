package dev.proj.project.application.services;

import dev.proj.project.application.dao.*;
import dev.proj.project.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserDAOImpl userDAOImpl;

    public List<User> getAllUsers(){
        return userDAOImpl.findAll();
    }

    public Optional<User> getUser(Integer id){
        return userDAO.findById(id);
    }

    public User saveUser(User user){
        return userDAO.save(user);
    }

    public void deleteUser(User user){
         userDAO.delete(user);
    }

}
