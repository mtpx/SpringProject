package dev.proj.project.application.dao;
import dev.proj.project.application.model.User;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


public class UserDAOImpl implements UserDAO {

    private EntityManager em;

    public UserDAOImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public User findByIdQuery(int userId) {
        return em.createNamedQuery(User.GET_USER_BY_ID, User.class)
                .setParameter("id",userId )
                .getSingleResult();
    }

    @Override
    public List<User> findAllQuery() {
        return em.createNamedQuery(User.GET_USERS, User.class)
                .getResultList();
    }

    @Override
    public <S extends User> S save(S s) {
        return null;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<User> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
