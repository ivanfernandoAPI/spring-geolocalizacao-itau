package com.itau.geo.googlemaps.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity(name = "google_maps_pesquisa")
public class GoogleMapsPesquisa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String device;
	
	private String placeId;
	
	private String browser;
	
	private String numeroAgencia;

	private String latitude;
	
	private String longitude;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dtInclusao;
}
