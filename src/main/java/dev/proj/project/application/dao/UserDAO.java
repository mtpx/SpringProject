package dev.proj.project.application.dao;
import dev.proj.project.application.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
    //User findById(int id);
    //List<User> findAll();
    //User save (User user);
    //void delete(User user);
    User findByIdQuery(int userId);
    List<User> findAllQuery();
}

