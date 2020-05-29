package com.itau.geo.googlemaps.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDadosAgencia implements Serializable{

    private static final long serialVersionUID = -8423529210979784745L;

    private String name;
    
    private String formatted_phone_number;
    
    @Getter(onMethod = @__({@JsonIgnore}))
    private Horario opening_hours;
    
    private String horario;
} 
