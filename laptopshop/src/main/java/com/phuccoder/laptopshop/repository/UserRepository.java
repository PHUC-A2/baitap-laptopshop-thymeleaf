package com.phuccoder.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phuccoder.laptopshop.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @SuppressWarnings({ "null", "unchecked" })
    @Override
    public User save(User user);
}
