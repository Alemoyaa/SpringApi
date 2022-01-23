package com.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.application.entity.AlbumEntity;
import com.application.repository.AlbumManagerRepository;

@Service
public class AlbumManagerService {
	
	private AlbumManagerRepository repository;

	public AlbumManagerService(AlbumManagerRepository repository) {
		this.repository = repository;
	}
	
	public AlbumEntity findById(long id) throws Exception {
		try {
			Optional<AlbumEntity> varOptional = repository.findById(id);
			if (varOptional.isPresent())
				return varOptional.get();
			else
				return null;
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}

	}
	
	public AlbumEntity save(AlbumEntity entity) throws Exception {
		try {
			entity = repository.save(entity);
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Iterable<AlbumEntity> findAll() throws Exception {
		try {
			return repository.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
