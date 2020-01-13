package dev.proj.project.application.services;

import dev.proj.project.application.dao.*;
import dev.proj.project.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAOCustom userDAO;

    @Override
    public User findByIdQuery(int id) {
        return userDAO.findByIdQuery(id);
    }

    @Override
    public List<User> findAllQuery() {
        return userDAO.findAllQuery();
    }

    @Override
    public int checkUser(String email, String password) {
        List<User> result = userDAO.checkUser(email, password);
        if(result.size()!=0) {
            return result.get(0).id; //logowanie udane
        }else {
            return 0; //logowanie nieudane
        }
    }
}
