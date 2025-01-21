package com.rigon.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rigon.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
    
}
