package com.itau.geo.googlemaps.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.geo.googlemaps.controller.form.AgenciaForm;
import com.itau.geo.googlemaps.dto.AgenciaDTO;
import com.itau.geo.googlemaps.dto.PosicaoDTO;
import com.itau.geo.googlemaps.dto.ResultDadosAgencia;
import com.itau.geo.googlemaps.dto.RetornoAgencias;
import com.itau.geo.googlemaps.service.GoogleMapsService;

@RestController
@RequestMapping(value = "googlemaps")
@CrossOrigin(origins="*", allowedHeaders="*")
public class GoogleMapsController {

    @Autowired
    private GoogleMapsService googleMapsService;
	
    @GetMapping("/agencias")
    public ResponseEntity<RetornoAgencias> buscaAgenciasPorPosicao(@PathParam("latitude") String latitude, @PathParam("longitude") String longitude, @PathParam("raio") Integer raio){
		
	PosicaoDTO posicaoDTO = new PosicaoDTO(latitude, longitude, raio);
	    
	RetornoAgencias retornoAgencias = googleMapsService.buscaAgenciasPorPosicao(posicaoDTO);
		
	return ResponseEntity.ok().body(retornoAgencias);
    }
    
    @PostMapping("/dadosagencia")
    public ResponseEntity<ResultDadosAgencia> buscaDadosAgencia(@RequestBody AgenciaForm form ){
	
	AgenciaDTO agenciaDTO = form.convert();
	
	ResultDadosAgencia resultDadosAgencia = googleMapsService.buscaDadosAgencia(agenciaDTO);
		
	return ResponseEntity.ok().body(resultDadosAgencia); 
    }
}
