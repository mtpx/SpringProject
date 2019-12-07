package dev.proj.project.application.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface UsersDAO extends CrudRepository<Users, Integer> {
    Users findById(int id);
}

