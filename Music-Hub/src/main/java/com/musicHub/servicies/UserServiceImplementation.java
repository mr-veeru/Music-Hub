package com.musicHub.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicHub.entities.Users;
import com.musicHub.repositories.UserRepo;

@Service
public class UserServiceImplementation implements UserService
{
	@Autowired
	UserRepo repo;
	
	@Override
	public String addUser(Users user) 
	{
		repo.save(user);
		return "User is created and saved ";
	}

	@Override
	public boolean emailExists(String email) 
	{
		if(repo.findByEmail(email) == null)
			return false;
		else
			return true;
	}

	@Override
	public boolean validateUser(String email, String password) 
	{
		Users user = repo.findByEmail(email);
		String dbPassword = user.getPassword();
		
		if(dbPassword.equals(password))
			return true;
		else
			return false;
	}
	
	@Override
	public String getRole(String email)
	{
		return (repo.findByEmail(email).getRole());
	}

	@Override
	public Users getUser(String email) 
	{
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) 
	{
		repo.save(user);
	}

}
