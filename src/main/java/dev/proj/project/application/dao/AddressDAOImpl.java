package dev.proj.project.application.dao;
import dev.proj.project.application.model.Address;
import dev.proj.project.application.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AddressDAOImpl implements AddressDAOCustom {

    private EntityManager em;

    public AddressDAOImpl(EntityManager em) {
        this.em = em;
    }

}
