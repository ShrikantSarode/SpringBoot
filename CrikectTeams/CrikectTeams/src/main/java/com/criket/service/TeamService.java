package com.criket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criket.entity.Teams;
import com.criket.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamrepository;

	// get all
	public List<Teams> allTeam() {
		return teamrepository.findAll();
	}

	// add

	public Teams addTeam(Teams teams) {
		return teamrepository.save(teams);
	}

	// find by id
	public Teams findById(Integer id) {
		Teams found = teamrepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
		return found;
	}

	// delete by id
	public String deleteById(Integer id) {
		Teams found = teamrepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
		teamrepository.delete(found);
		return "Team Deleted !!";
	}
}
