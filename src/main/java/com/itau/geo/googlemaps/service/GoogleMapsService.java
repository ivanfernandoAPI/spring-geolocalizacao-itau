package com.itau.geo.googlemaps.service;

import com.itau.geo.googlemaps.dto.AgenciaDTO;
import com.itau.geo.googlemaps.dto.PosicaoDTO;
import com.itau.geo.googlemaps.dto.ResultDadosAgencia;
import com.itau.geo.googlemaps.dto.RetornoAgencias;

public interface GoogleMapsService {

	RetornoAgencias buscaAgenciasPorPosicao(PosicaoDTO posicaoDTO);
	ResultDadosAgencia buscaDadosAgencia(AgenciaDTO agenciaDTO);
}
