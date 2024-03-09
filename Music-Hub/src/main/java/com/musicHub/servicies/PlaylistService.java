package com.musicHub.servicies;

import java.util.List;

import com.musicHub.entities.Playlist;

public interface PlaylistService 
{

	public void addPlayList(Playlist playlist);

	public List<Playlist> fetchPlaylists();

}
