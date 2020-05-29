package com.itau.geo.googlemaps.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.geo.external.api.GoogleMapsCallAPI;
import com.itau.geo.googlemaps.dto.AgenciaDTO;
import com.itau.geo.googlemaps.dto.PosicaoDTO;
import com.itau.geo.googlemaps.dto.ResultDadosAgencia;
import com.itau.geo.googlemaps.dto.RetornoAgencias;
import com.itau.geo.googlemaps.dto.RetornoDadosAgencia;
import com.itau.geo.googlemaps.model.GoogleMapsPesquisa;
import com.itau.geo.googlemaps.repository.GoogleMapsRepository;
import com.itau.geo.googlemaps.service.GoogleMapsService;

 @Service
 public class GoogleMapsServiceImpl implements GoogleMapsService {
     
    @Autowired 
    private GoogleMapsRepository googleMapsRepository;
	
    @Override
    public RetornoAgencias buscaAgenciasPorPosicao(PosicaoDTO posicaoDTO) {
	RetornoAgencias retornoAgencias = GoogleMapsCallAPI.buscaAgenciasPorPosicao(posicaoDTO);
	
        return retornoAgencias;
    }
    
    @Override
    public ResultDadosAgencia buscaDadosAgencia(AgenciaDTO agenciaDTO) {
	
	ResultDadosAgencia resultDadosAgencia = new ResultDadosAgencia();
	// Busca os dados da Agencia
	RetornoDadosAgencia retornoDadosAgencia = GoogleMapsCallAPI.buscaDadosAgencia(agenciaDTO.getPlaceId());
	
	if (retornoDadosAgencia.getResult() != null) {
	    resultDadosAgencia = retornoDadosAgencia.getResult();
	    
		GoogleMapsPesquisa googleMapsPesquisa = new GoogleMapsPesquisa();
		
		googleMapsPesquisa.setPlaceId(agenciaDTO.getPlaceId());
		googleMapsPesquisa.setBrowser(agenciaDTO.getBrowser());
		googleMapsPesquisa.setDevice(agenciaDTO.getDevice());
		googleMapsPesquisa.setNumeroAgencia(resultDadosAgencia.getFormatted_phone_number());
		googleMapsPesquisa.setLatitude(agenciaDTO.getLatitude());
		googleMapsPesquisa.setLongitude(agenciaDTO.getLongitude());
		googleMapsPesquisa.setDtInclusao(new Date());
		
		googleMapsRepository.save(googleMapsPesquisa);
		
		resultDadosAgencia.setHorario(trataArrayHoras(resultDadosAgencia.getOpening_hours().getWeekday_text()));
	}
	
	return resultDadosAgencia;
    }
    
    private String trataArrayHoras (List<String> horarios) {
	
	StringBuffer sb = new StringBuffer();
	
	for (String hor: horarios) {
	    sb.append(traduzTexto(hor)).append("\n");
	}
	
	System.out.println(sb.toString());
	return sb.toString();
    }
    
    private String traduzTexto (String texto) {
	
	if (texto.contains("Monday")) { texto = texto.replace("Monday", "Segunda-Feira"); }
	if (texto.contains("Tuesday")) { texto = texto.replace("Tuesday", "Terça-Feira"); }
	if (texto.contains("Wednesday:")) { texto = texto.replace("Wednesday", "Quarta-Feira"); }
	if (texto.contains("Thursday:")) { texto = texto.replace("Thursday", "Quinta-Feira"); }
	if (texto.contains("Friday:")) { texto = texto.replace("Friday", "Sexta-Feira"); }
	if (texto.contains("Saturday:")) { texto = texto.replace("Saturday", "Sábado"); }
	if (texto.contains("Sunday:")) { texto = texto.replace("Sunday", "Domingo"); }
	if (texto.contains("Closed")) { texto = texto.replace("Closed", " Fechado"); }
	
	return texto;
    }
 }
