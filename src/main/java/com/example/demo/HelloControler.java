package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HelloControler {
	
	@Autowired
	UserService service;
	
	@GetMapping("/hello/{id}")
	public User gethello(@PathVariable Long id){
		User user = service.getUserById(id).get();
		return user;
		
	}
	
	@PostMapping("/hello")
	public User createUser(@RequestBody User user) {
		
		try {
		return service.save(user);}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@PutMapping("hello/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Long id) {
		
		User updatedUser =service.getUserById(id).map(s ->{ s.setName(user.name);
		s.setLastName(user.lastName);
		return s;}).orElse(service.save(user));
		
		return updatedUser;
	}
	
	@DeleteMapping("hello/{id}")
	public void deleteUser(@PathVariable  Long id) {
		
		service.deleteById(id);
		
	}
	

}
