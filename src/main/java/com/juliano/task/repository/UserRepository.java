package com.juliano.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juliano.task.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
