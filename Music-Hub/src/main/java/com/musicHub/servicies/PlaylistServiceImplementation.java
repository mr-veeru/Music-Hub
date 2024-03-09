package com.musicHub.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicHub.entities.Playlist;
import com.musicHub.repositories.PlaylistRepo;

@Service
public class PlaylistServiceImplementation implements PlaylistService
{
	@Autowired
	PlaylistRepo repo;

	@Override
	public void addPlayList(Playlist playlist) 
	{
		repo.save(playlist);
	}

	@Override
	public List<Playlist> fetchPlaylists() 
	{
		return repo.findAll();
	}

}
