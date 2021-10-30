package com.api.consumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.consumer.dto.PessoaDTO;
import com.api.consumer.model.Pessoa;
import com.api.consumer.service.PessoaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PessoaListener {
	
	@Autowired
	private PessoaService pessoaService;
	
	@RabbitListener(queues = "fila_pessoa")
	public void save(String json) throws JsonMappingException, JsonProcessingException {
		
		PessoaDTO pessoaDTO = new ObjectMapper().readValue(json, PessoaDTO.class);
		
		Pessoa pessoa = new Pessoa();
		BeanUtils.copyProperties(pessoaDTO, pessoa);
		
		pessoaService.save(pessoa);
	}

}
