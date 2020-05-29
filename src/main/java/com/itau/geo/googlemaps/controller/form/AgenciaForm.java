package com.itau.geo.googlemaps.controller.form;

import com.itau.geo.googlemaps.dto.AgenciaDTO;

import lombok.Data;

@Data
public class AgenciaForm {
    
    private String placeId;
    
    private String device;
    
    private String browser;
    
    private String latitude;
    
    private String longitude;
	
    public AgenciaDTO convert() {
	return new AgenciaDTO(placeId, device, browser, latitude , longitude);
    }
} 
