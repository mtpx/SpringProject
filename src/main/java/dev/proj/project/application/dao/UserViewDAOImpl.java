package dev.proj.project.application.dao;

import dev.proj.project.application.model.User;
import dev.proj.project.application.model.UserView;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserViewDAOImpl implements UserViewDAOCustom {

    private EntityManager em;

    public UserViewDAOImpl(EntityManager em) {
        this.em = em;
    }

//    @Override
//    public List<UserView> findByUserId(int id) {
//        return em.createNamedQuery(UserView.GET_DATA_BY_USERID, UserView.class)
//                .setParameter("id",id )
//                .getResultList();
//    }

}
