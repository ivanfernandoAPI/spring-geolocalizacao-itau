package com.itau.geo.googlemaps.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Horario implements Serializable{

    private static final long serialVersionUID = -8423529210979784745L;

    private List<String> weekday_text;

} 
