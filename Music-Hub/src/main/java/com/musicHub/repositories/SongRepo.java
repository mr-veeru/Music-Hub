package com.musicHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicHub.entities.Songs;

public interface SongRepo extends JpaRepository<Songs, Integer>
{
	public Songs findByName(String name);
}
