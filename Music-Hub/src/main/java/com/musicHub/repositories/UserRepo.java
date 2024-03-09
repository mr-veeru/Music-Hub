package com.musicHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicHub.entities.Users;

public interface UserRepo extends JpaRepository<Users, Integer>
{
	public Users findByEmail(String email);
}
