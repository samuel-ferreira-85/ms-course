package com.samuel.hruser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samuel.hruser.entities.User;
import com.samuel.hruser.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User usuario = userRepository.findById(id).get();
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> findById(@RequestParam String email) {
		User usuario = userRepository.findByEmail(email);
		return ResponseEntity.ok(usuario);
	}
}
