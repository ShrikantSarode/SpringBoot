package com.criket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criket.entity.Players;
import com.criket.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	// add
	public Players addPlayer(Players players) {
		return playerRepository.save(players);
	}

	// get all
	public List<Players> allPlayers() {
		return playerRepository.findAll();
	}

	// find by id
	public Players findById(Integer id) {
		Players found = playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found" + id));

		return found;
	}

	// delete by id
	public String deleteById(Integer id) {
		Players found = playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found" + id));

		playerRepository.delete(found);

		return "Player Deleted!!";
	}
}
