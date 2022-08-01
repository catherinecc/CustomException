package com.example.demo;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

	User getUserById(Long id);

	User save(User user);

	void deleteById(Long id);

}
