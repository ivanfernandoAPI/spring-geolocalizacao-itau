package com.itau.geo.googlemaps.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PosicaoDTO implements Serializable{
    
    private static final long serialVersionUID = 2538747162125971851L;

    private String latitude;
    
    private String longitude;
    
    private Integer raio;
    
} 
