package pl.coderslab.finalproject.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.model.User;
import pl.coderslab.finalproject.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaUserService implements UserService {
    private final UserRepository userRepository;

    public JpaUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> get() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean checkPassword(String candidate, String hashed) {
        if (BCrypt.checkpw(candidate, hashed)) {
            return true;
        } else {
            return false;
        }
    }
}
