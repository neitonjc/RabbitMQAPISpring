package com.api.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.consumer.model.TituloReceberRep;
import com.api.consumer.repository.TituloReceberRepository;


@Service
public class TituloReceberService {
	
	@Autowired
	private TituloReceberRepository rep;
	
	public TituloReceberRep incluir(TituloReceberRep tituloReceberRep) throws Exception {
		try {
			return rep.save(tituloReceberRep);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
}
