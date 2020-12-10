package com.project.trade_buddy.repository;

import com.project.trade_buddy.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByAuthId(String authId);

}
