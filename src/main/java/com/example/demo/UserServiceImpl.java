package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo repo;

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		
			return repo.findById(id).get();
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		try {
		
		if(user.getLastName()==null|| user.getLastName().isBlank()) {
			throw new UserNotFoundException("602", "lastname is Empty");
		}
		}
		catch(Exception  e) {
			System.out.println("Caught it"+ e.getClass());
		throw new UserNotFoundException("603","problem in service layer", e);
		
		}
		return repo.save(user);
	}

	@Override
	public void deleteById(Long id) {
		 repo.deleteById(id);
		
	}

	
	

}
