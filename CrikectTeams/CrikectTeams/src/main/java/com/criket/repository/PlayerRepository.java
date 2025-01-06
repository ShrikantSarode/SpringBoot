package com.criket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criket.entity.Players;

public interface PlayerRepository extends JpaRepository<Players, Integer> {

}
