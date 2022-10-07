package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(User user);
    List<User> get();
    Optional<User> getById(Long id);
    String hashPassword(String password);
    boolean checkPassword(String candidate, String hashed);
}
