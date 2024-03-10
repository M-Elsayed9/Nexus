package com.nexus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexus.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByUserName(String userName);
}
