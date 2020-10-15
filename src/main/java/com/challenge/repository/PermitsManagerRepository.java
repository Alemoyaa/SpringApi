package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.entity.PermitsEntity;

@Repository
public interface PermitsManagerRepository extends JpaRepository<PermitsEntity, Long>{

}
