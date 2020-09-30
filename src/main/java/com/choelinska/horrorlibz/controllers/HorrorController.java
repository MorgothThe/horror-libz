package com.choelinska.horrorlibz.controllers;

import com.choelinska.horrorlibz.model.dto.HorrorTo;
import com.choelinska.horrorlibz.services.HorrorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horror")
public class HorrorController {

	private HorrorService horrorService;

	public HorrorController(HorrorService horrorService){
		this.horrorService = horrorService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addHorror(@RequestBody HorrorTo horror){
		horrorService.addHorror(horror);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteHorror(@PathVariable long id){
		horrorService.removeHorror(id);
	}
}
