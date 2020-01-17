package dev.proj.project.application.dao;
import dev.proj.project.application.model.Address;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AddressDAOImpl implements AddressDAOCustom {

    private EntityManager em;

    public AddressDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Address> findAll() {
        return em.createNamedQuery(Address.GET_ADDRESSES, Address.class)
                .getResultList();
    }

    @Override
    public List<Address> findAddressesByUserId(int userId) {
        return em.createNamedQuery(Address.GET_ADDRESSES_BY_USERID, Address.class)
                .setParameter("userId",userId )
                .getResultList();
    }
}
