package com.itau.geo.googlemaps.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RetornoDadosAgencia implements Serializable{

    private static final long serialVersionUID = 8542646743009358774L;
    
    private ResultDadosAgencia result;
    
    private String status;
    
} 
