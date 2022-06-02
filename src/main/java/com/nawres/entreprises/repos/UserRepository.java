package com.nawres.entreprises.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nawres.entreprises.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}
