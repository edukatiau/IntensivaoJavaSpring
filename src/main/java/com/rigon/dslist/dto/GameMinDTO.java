package com.rigon.dslist.dto;

import com.rigon.dslist.entities.Game;
import com.rigon.dslist.projections.GameMinProjection;

import lombok.Data;

@Data
public class GameMinDTO {
    
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(Game entity){
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public GameMinDTO(GameMinProjection projection){
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getGameYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }
}
