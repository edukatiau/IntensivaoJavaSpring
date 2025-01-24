package com.rigon.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rigon.dslist.dto.GameListDTO;
import com.rigon.dslist.entities.GameList;
import com.rigon.dslist.projections.GameMinProjection;
import com.rigon.dslist.repositories.GameListRepository;
import com.rigon.dslist.repositories.GameRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gamelistrepository;

    @Autowired
    private GameRepository gameRepository;

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

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++){
            gamelistrepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
