package com.itau.geo.googlemaps.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result implements Serializable{

    private static final long serialVersionUID = -8423529210979784745L;

    private String name;
    
    private String place_id;
    
    private String vicinity;
} 
