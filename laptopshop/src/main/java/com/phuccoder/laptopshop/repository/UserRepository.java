package com.phuccoder.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phuccoder.laptopshop.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findById(long id);
}
