package com.springboot.springsecurity.repository;

import com.springboot.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> findByEmail(String username);
}
