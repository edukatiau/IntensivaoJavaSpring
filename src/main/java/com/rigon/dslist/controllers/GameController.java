package com.rigon.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rigon.dslist.dto.GameDTO;
import com.rigon.dslist.dto.GameMinDTO;
import com.rigon.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> list = gameService.findAll();
        return list;
    }

    @GetMapping(value = "/{id}")
    public GameDTO findGame(@PathVariable Long id){
        GameDTO game = gameService.findById(id);
        return game;
    }
}
