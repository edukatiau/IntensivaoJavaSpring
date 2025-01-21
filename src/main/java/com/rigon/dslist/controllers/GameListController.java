package com.rigon.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rigon.dslist.dto.GameListDTO;
import com.rigon.dslist.services.GameListService;

@RestController
@RequestMapping(value = "list")
public class GameListController {
    
    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> list = gameListService.findAll();
        return list;
    }

    @GetMapping(value = "/{id}")
    public GameListDTO findGame(@PathVariable Long id){
        GameListDTO game = gameListService.findById(id);
        return game;
    }
}
