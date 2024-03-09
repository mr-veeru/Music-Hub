package com.musicHub.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.musicHub.entities.Songs;
import com.musicHub.servicies.SongService;

@Controller
public class SongsController 
{
	@Autowired
	SongService songService;
	
	@PostMapping("/addSongs")
	public ResponseEntity<Map<String, Object>> addSongs(@ModelAttribute Songs song) {
	    Map<String, Object> response = new HashMap<>();
	    HttpStatus status;

	    if (!songService.songExist(song.getName())) {
	        songService.addSong(song);
	        response.put("success", true);
	        status = HttpStatus.OK;
	    } else {
	        response.put("success", false);
	        status = HttpStatus.BAD_REQUEST;
	    }

	    return new ResponseEntity<>(response, status);
	}

	
	@GetMapping("/map-viewSongs")
	public String viewSongs(Model model)
	{
		List<Songs> songsList = songService.fetchAllSongs();
		model.addAttribute("songsList", songsList);
		return "displaySongs";
	}
	@GetMapping("/mapViewSongsAdmin")
	public String mapViewSongsAdmin(Model model)
	{
		List<Songs> songsList = songService.fetchAllSongs();
		model.addAttribute("songsList", songsList);
		return "displaySongsAdmin";
	}
	
	@GetMapping("/viewSongs")
	public String viewCustomerSongs(Model model)
	{
		boolean primeCustomerStatus = false;
		
		if(primeCustomerStatus == true)
		{
			List<Songs> songsList = songService.fetchAllSongs();
			model.addAttribute("songsList", songsList);
			return "displaySongs";
		}
		else
		{
			return "makePayment";
		}
	}
}
