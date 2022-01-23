package com.application.controller;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.entity.PermitsEntity;
import com.application.entity.UserEntity;
import com.application.service.UserManagerService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@RequestMapping(path = "api/manager/users")
@Transactional
public class UserManagerController {

	private UserManagerService service;

	public UserManagerController(UserManagerService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.ok().body(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error. Please try again later \": \"" + e.getMessage() + "\"}");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) {
		try {
			return ResponseEntity.ok().body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error. Please check the ID, and try again later \": \"" + e.getMessage() + "\"}");
		}
	}
	
	@GetMapping("/read/{idAlbum}")
	public ResponseEntity<?> getAllUserByPermitsRead(@PathVariable long idAlbum) {
		try {
			return ResponseEntity.ok().body(service.findAllUserByPermits(idAlbum, true));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error. Please check the ID, and try again later \": \"" + e.getMessage() + "\"}");
		}
	}

	@GetMapping("/write/{idAlbum}")
	public ResponseEntity<?> getAllUserByPermitsWrite(@PathVariable long idAlbum) {
		try {
			return ResponseEntity.ok().body(service.findAllUserByPermits(idAlbum, false));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error. Please check the ID, and try again later \": \"" + e.getMessage() + "\"}");
		}
	}

	@PostMapping("/")
	public ResponseEntity<?> post(@RequestBody UserEntity dto) {
		try {
			return ResponseEntity.ok().body(service.save(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN)
					.body("{\"message\": \"Error. Please check the BODY request, and try again later.\"}");
		}
	}

	@PutMapping("/{id}/albums/")
	public ResponseEntity<?> putPermitsUser(@PathVariable long id, @RequestBody PermitsEntity dto) {
		try {
			return ResponseEntity.ok().body(service.updatePermitsUser(id, dto));
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");
		}
	}

}
