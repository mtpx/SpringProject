package dev.proj.project.application.services;

import dev.proj.project.application.dao.*;
import dev.proj.project.application.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User findById (int userId);
}
