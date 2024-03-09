package com.musicHub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController 
{
	@GetMapping("/map-register")
	public String registerMapping()
	{
		return "register";
	}
	
	@GetMapping("/map-login")
	public String loginMapping()
	{
		return "login";
	}
	
	@GetMapping("/map-songs")
	public String songMapping()
	{
		return "addSongs";
	}
	
	@GetMapping("/samplePayment")
	public String samplePayment()
	{
		return "samplePayment";
	}
	
	@GetMapping("/adminHome")
	public String adminHome()
	{
		return "adminHome";
	}
	
	@GetMapping("/customerHome")
	public String customerHome()
	{
		return "customerHome";
	}
}
