package dev.proj.project.application.dao;
import dev.proj.project.application.model.Home;
import dev.proj.project.application.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HomeDAO extends CrudRepository<Home,Integer>, HomeDAOCustom {
    List<Home> findAll();
}

