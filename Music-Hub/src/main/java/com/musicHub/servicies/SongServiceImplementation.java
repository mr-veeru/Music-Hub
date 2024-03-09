package com.musicHub.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicHub.entities.Songs;
import com.musicHub.repositories.SongRepo;

@Service
public class SongServiceImplementation implements SongService
{
	@Autowired
	SongRepo repo;
	
	@Override
	public String addSong(Songs song) 
	{
		repo.save(song);
		return "Song added successully";
	}

	@Override
	public boolean songExist(String name) 
	{
		Songs song = repo.findByName(name);
		if(song == null)
			return false;
		else
			return true;
	}

	@Override
	public List<Songs> fetchAllSongs() 
	{
		return repo.findAll();
	}

	@Override
	public void updateSong(Songs song) 
	{
		repo.save(song);
	}
}
