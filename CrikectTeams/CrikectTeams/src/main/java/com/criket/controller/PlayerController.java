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

import com.criket.entity.Players;
import com.criket.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	// add
	@PostMapping("/add")
	public ResponseEntity<?> addPlayer(@RequestBody Players players) {

		playerService.addPlayer(players);
		return new ResponseEntity<>("Player Added!!", HttpStatus.CREATED);

	}

	// all
	@GetMapping("/all")
	public ResponseEntity<?> allPlayers() {
		playerService.allPlayers();
		return new ResponseEntity<>("Fetched", HttpStatus.OK);
	}

	// find
	@GetMapping("/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Players playerFound = playerService.findById(id);
		return new ResponseEntity<>(playerFound, HttpStatus.OK);
	}

//	delete
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		playerService.deleteById(id);
		return new ResponseEntity<>("Found!!", HttpStatus.OK);
	}
}
