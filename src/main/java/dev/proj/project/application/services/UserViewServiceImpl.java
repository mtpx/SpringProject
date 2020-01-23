package dev.proj.project.application.services;
import dev.proj.project.application.dao.UserViewDAO;
import dev.proj.project.application.model.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserViewServiceImpl implements UserViewService {
    @Autowired
    private UserViewDAO userViewDAO;

    @Override
    public int getValueOfHomes(int userId) {
        int sumOfPrices=0;
        List<UserView> result =userViewDAO.findByUserId(userId);
        for (int i=0;i<result.size();i++){
            sumOfPrices+=result.get(i).price;
        }
        return sumOfPrices;
    }

    public int getNumberOfHomes(int userId) {
        List<UserView> result =userViewDAO.findByUserId(userId);
        return result.size();
    }
}
