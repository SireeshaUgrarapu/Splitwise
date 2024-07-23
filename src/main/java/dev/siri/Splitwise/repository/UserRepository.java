package dev.siri.Splitwise.repository;

import dev.siri.Splitwise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByEmail(String email);
}
