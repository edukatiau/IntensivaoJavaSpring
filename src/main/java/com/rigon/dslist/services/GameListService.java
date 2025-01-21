package com.rigon.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rigon.dslist.dto.GameListDTO;
import com.rigon.dslist.entities.GameList;
import com.rigon.dslist.repositories.GameListRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gamelistrepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> list = gamelistrepository.findAll();
        List<GameListDTO> dto = list.stream().map(game -> new GameListDTO(game)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id){
        GameList gameList = gamelistrepository.findById(id).get();
        GameListDTO dto = new GameListDTO(gameList);
        return dto;
    }
}
