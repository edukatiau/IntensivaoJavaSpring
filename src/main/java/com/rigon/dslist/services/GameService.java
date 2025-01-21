package com.rigon.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rigon.dslist.dto.GameMinDTO;
import com.rigon.dslist.entities.Game;
import com.rigon.dslist.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> list = gameRepository.findAll();
        List<GameMinDTO> dto = list.stream().map(game -> new GameMinDTO(game)).toList();
        return dto;
    }

}
