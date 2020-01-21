package dev.proj.project.application.dao;

import dev.proj.project.application.model.Home;
import dev.proj.project.application.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HomeDAOImpl implements HomeDAOCustom {

    private EntityManager em;

    public HomeDAOImpl(EntityManager em) {
        this.em = em;
    }

//    @Override
//    public Home findById(int id) {
//        return em.createNamedQuery(Home.GET_HOME_BY_ID, Home.class)
//                .setParameter("id",id )
//                .getSingleResult();
//    }
//
//    @Override
//    public List<User> findAllQuery() {
//        return em.createNamedQuery(User.GET_USERS, User.class)
//                .getResultList();
//    }
//
//    @Override
//    public List<User> checkUser(String email, String password) {
//        return em.createNamedQuery(User.CHECK_USER, User.class)
//                .setParameter("email", email)
//                .setParameter("password", password)
//                .getResultList();
//    }
}
