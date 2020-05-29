package com.itau.geo.googlemaps.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.itau.geo.googlemaps.model.GoogleMapsPesquisa;

public interface GoogleMapsRepository extends CrudRepository<GoogleMapsPesquisa, Long>, JpaSpecificationExecutor<GoogleMapsPesquisa>{

}
