package com.criket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.criket.entity.Teams;
import com.criket.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;

//	add
	@PostMapping("/add")
	public ResponseEntity<?> addTeam(@RequestBody Teams teams) {
		teamService.addTeam(teams);
		return new ResponseEntity<>("Added!!", HttpStatus.OK);
	}

//	get all
	@GetMapping("/all")
	public ResponseEntity<?> allTeam() {
		teamService.allTeam();
		return new ResponseEntity<>("Fetched", HttpStatus.OK);
	}

//	find
	@GetMapping("/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		teamService.findById(id);
		return new ResponseEntity<>("Founded", HttpStatus.OK);
	}

//	delete
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		teamService.deleteById(id);
		return new ResponseEntity<>("Founded", HttpStatus.OK);
	}
}
