package com.musicHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.musicHub.entities.Playlist;
import com.musicHub.entities.Songs;
import com.musicHub.servicies.PlaylistService;
import com.musicHub.servicies.SongService;

@Controller
public class PlaylistController 
{
	@Autowired
	PlaylistService playlistService;
	
	@Autowired
	SongService songService;
	
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model)
	{
		List<Songs> songsList = songService.fetchAllSongs();
		model.addAttribute("songsList", songsList);
		return "createPlaylist";
	}
	
	@GetMapping("/createPlaylistAdmin")
	public String createPlaylistAdmin(Model model)
	{
		List<Songs> songsList = songService.fetchAllSongs();
		model.addAttribute("songsList", songsList);
		return "createPlaylistAdmin";
	}
	
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist)
	{
		playlistService.addPlayList(playlist);
		
		List<Songs> songsList = playlist.getSong();
		for(Songs song : songsList)
		{
			song.getPlayList().add(playlist);
			songService.updateSong(song);
		}
		
		return "playListSuccess";
	}
	
	@PostMapping("/addPlaylistAdmin")
	public String addPlaylistAdmin(@ModelAttribute Playlist playlist)
	{
		playlistService.addPlayList(playlist);
		
		List<Songs> songsList = playlist.getSong();
		for(Songs song : songsList)
		{
			song.getPlayList().add(playlist);
			songService.updateSong(song);
		}
		
		return "playListSuccessAdmin";
	}
	
	@GetMapping("/viewPlaylist")
	public String viewPlaylist(Model model)
	{
		List<Playlist> playlist = playlistService.fetchPlaylists();
		model.addAttribute("playlist", playlist);
		return "viewPlaylist";
	}
	@GetMapping("/viewPlaylistAdmin")
	public String viewPlaylistAdmin(Model model)
	{
		List<Playlist> playlist = playlistService.fetchPlaylists();
		model.addAttribute("playlist", playlist);
		return "viewPlaylistAdmin";
	}
}
