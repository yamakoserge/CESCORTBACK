package com.gsoftcode.cescortback.repository;

import com.gsoftcode.cescortback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CescortRepository extends JpaRepository<User, Long> {

    User findFirstByEmail(String email);
}
