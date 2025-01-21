package com.rigon.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.rigon.dslist.entities.GameList;

import lombok.Data;

@Data
public class GameListDTO {
    
    private Long id;
    private String name;

    public GameListDTO(GameList entity){
        BeanUtils.copyProperties(entity, this);
    }
}
