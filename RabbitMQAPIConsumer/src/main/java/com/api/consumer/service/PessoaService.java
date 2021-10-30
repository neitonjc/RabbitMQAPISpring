package com.api.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.consumer.model.Pessoa;
import com.api.consumer.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void save(Pessoa p) {
		pessoaRepository.save(p);
	}

}
