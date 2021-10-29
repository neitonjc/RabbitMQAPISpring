package com.api.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.consumer.model.TituloReceberRep;
import com.api.consumer.model.id.TituloReceberRepId;



public interface TituloReceberRepository extends JpaRepository<TituloReceberRep, TituloReceberRepId> {
	
}
