package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.entity.AlbumEntity;

@Repository
public interface AlbumManagerRepository extends JpaRepository<AlbumEntity, Long>{

}
