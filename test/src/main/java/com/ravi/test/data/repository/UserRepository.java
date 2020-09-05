package com.ravi.test.data.repository;

import com.ravi.test.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUserId(String userId);
    List<User> findAll();
    User save(User user);
}
