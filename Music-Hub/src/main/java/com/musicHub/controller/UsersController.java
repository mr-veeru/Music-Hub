package com.musicHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.musicHub.entities.Songs;
import com.musicHub.entities.Users;
import com.musicHub.servicies.SongService;
import com.musicHub.servicies.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController 
{
	@Autowired
	UserService userService;
	
	@Autowired
	SongService songService;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user)
	{
		boolean userStatus = userService.emailExists(user.getEmail());
		if(userStatus == false)
		{
			userService.addUser(user);
			System.out.println("User added sucessfully");
			return "registerSuccess";
		}
		else
		{
			System.out.println("User already exist");
			return "registerFail";
		}		
	}
	
	@PostMapping("/login")
	public String validateUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
	    session.setAttribute("email", email);
	    Users user = userService.getUser(email);
	    if (user != null && userService.validateUser(email, password)) {
	        if ("admin".equals(userService.getRole(email))) {
	            return "adminHome";
	        } else {
	            return "customerHome";
	        }
	    } else {
	        return "loginFail";
	    }
	}


	
	@GetMapping("/exploreSongs")
	public String exploreSongs(HttpSession session, Model model)
	{
		String email = (String) session.getAttribute("email");
		Users user = userService.getUser(email);
		if(user.isPremium() == true)
		{
			List<Songs> songsList = songService.fetchAllSongs();
			model.addAttribute("songsList", songsList);
			return "displaySongs";
		}
		else
		{
			return "samplePayment";
		}
	}
	
}
