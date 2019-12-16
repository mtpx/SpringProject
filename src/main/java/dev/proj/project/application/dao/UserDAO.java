package dev.proj.project.application.dao;
import dev.proj.project.application.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
    User findById(int id);

    @Override
    List<User> findAll();

    @Override
    User save (User user);

    @Override
    void delete(User user);
}

