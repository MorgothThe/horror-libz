package com.choelinska.horrorlibz.controllers;

import com.choelinska.horrorlibz.model.dto.HorrorTo;
import com.choelinska.horrorlibz.services.HorrorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horror")
public class HorrorControllers {

	private HorrorService horrorService;

	public HorrorControllers(HorrorService horrorService){
		this.horrorService = horrorService;
	}
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addHorror(@RequestBody HorrorTo horror){
		horrorService.addHorror(horror);
	}
}
