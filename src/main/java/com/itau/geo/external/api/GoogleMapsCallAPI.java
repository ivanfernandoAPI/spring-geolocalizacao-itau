package com.itau.geo.external.api;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.google.gson.Gson;
import com.itau.geo.googlemaps.dto.PosicaoDTO;
import com.itau.geo.googlemaps.dto.RetornoAgencias;
import com.itau.geo.googlemaps.dto.RetornoDadosAgencia;
import com.itau.geo.util.ConsumerProperties;


public class GoogleMapsCallAPI {
	
    private static Gson gson = new Gson();
	
    public static RetornoAgencias buscaAgenciasPorPosicao(PosicaoDTO posicaoDTO) {
	
	String endPoint = "https://maps.googleapis.com";
	String keyApi = "AIzaSyCXBOmXhPdOAGXuWFaueN0AcoC3MMYpIt4";
	
	try {
	    Properties properties = ConsumerProperties.getPropEnvironment();
	    
	    endPoint = properties.getProperty("endpoint.api.googlemaps");
	    keyApi   = properties.getProperty("key.api.googlemaps");
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
		
	StringBuffer url = new StringBuffer(endPoint);
	
	url.append("/maps/api/place/nearbysearch/json?location=").append(posicaoDTO.getLatitude()).append(",").append(posicaoDTO.getLongitude())
	   .append("&radius=").append(posicaoDTO.getRaio()).append("&type=").append("bank").append("&keyword=").append("itau").append("&key=").append(keyApi);
	    
	HttpClient httpClient= null;
	GetMethod getMethod = null;
		
	try {
	     httpClient = new HttpClient();
			
	     getMethod = new GetMethod(url.toString());

	} catch (Exception e) {
	    e.printStackTrace();
	}
    	  
	String response = "";
		
	try {
	    httpClient.executeMethod(getMethod);
			
	    response = getMethod.getResponseBodyAsString();
	} catch (IOException e) {
	    	e.printStackTrace();
	}
	
	RetornoAgencias retornoAgencias = gson.fromJson(response, RetornoAgencias.class);
	
	return retornoAgencias; 		
    }
    
    public static RetornoDadosAgencia buscaDadosAgencia(String placeID) {
	    
	String endPoint = "https://maps.googleapis.com";
	String keyApi = "AIzaSyCXBOmXhPdOAGXuWFaueN0AcoC3MMYpIt4";
	
	try {
	    Properties properties = ConsumerProperties.getPropEnvironment();
	    
	    endPoint = properties.getProperty("endpoint.api.googlemaps");
	    keyApi   = properties.getProperty("key.api.googlemaps");
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	
	StringBuffer url = new StringBuffer(endPoint);
	
	url.append("/maps/api/place/details/json?place_id=").append(placeID).append("&fields=").append("name,opening_hours,formatted_phone_number")
	   .append("&key=").append(keyApi);
	    
	HttpClient httpClient= null;
	GetMethod getMethod = null;
		
	try {
	     httpClient = new HttpClient();
			
	     getMethod = new GetMethod(url.toString());

	} catch (Exception e) {
	    e.printStackTrace();
	}
    	  
	String response = "";
		
	try {
	    httpClient.executeMethod(getMethod);
			
	    response = getMethod.getResponseBodyAsString();
	} catch (IOException e) {
	    	e.printStackTrace();
	}
	
	RetornoDadosAgencia retornoAgencias = gson.fromJson(response, RetornoDadosAgencia.class);
	
	return retornoAgencias; 		
    }
    
    
}

