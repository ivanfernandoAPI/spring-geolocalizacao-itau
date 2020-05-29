package com.itau.geo.googlemaps.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RetornoAgencias implements Serializable{

    private static final long serialVersionUID = 8542646743009358774L;
    
    private List<Result> results;
    
    private String status;
    
} 
