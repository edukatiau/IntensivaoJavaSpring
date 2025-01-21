package com.rigon.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rigon.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
    
}
