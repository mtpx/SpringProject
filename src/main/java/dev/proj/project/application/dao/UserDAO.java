package dev.proj.project.application.dao;
import dev.proj.project.application.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

    @Query
    List<User> retriveUsers();

    @Query
    User retriveUser(@Param("ID") int user_id);

    User findByIdQuery(int userId);

    List<User> findAllQuery();

}

