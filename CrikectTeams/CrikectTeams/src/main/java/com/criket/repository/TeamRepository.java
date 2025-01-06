package com.criket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criket.entity.Teams;

public interface TeamRepository extends JpaRepository<Teams, Integer> {

}
