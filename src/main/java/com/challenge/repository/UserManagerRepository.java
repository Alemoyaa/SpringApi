package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.entity.UserEntity;

@Repository
public interface UserManagerRepository extends JpaRepository<UserEntity, Long> {
}
