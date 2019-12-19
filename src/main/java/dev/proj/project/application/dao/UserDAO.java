package dev.proj.project.application.dao;
import dev.proj.project.application.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User,Integer>, UserDAOCustom {
}

