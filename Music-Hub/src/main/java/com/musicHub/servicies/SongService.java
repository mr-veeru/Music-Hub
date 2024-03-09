package com.musicHub.servicies;

import java.util.List;

import com.musicHub.entities.Songs;

public interface SongService 
{
	public String addSong(Songs song);
	public boolean songExist(String name);
	
	public List<Songs> fetchAllSongs();
	
	public void updateSong(Songs song);
}
