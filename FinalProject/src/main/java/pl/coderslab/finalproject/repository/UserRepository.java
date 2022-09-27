package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
