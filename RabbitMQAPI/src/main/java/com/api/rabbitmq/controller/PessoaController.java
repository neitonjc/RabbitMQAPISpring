package com.api.rabbitmq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.rabbitmq.constantes.RabbitMQConstantes;
import com.api.rabbitmq.dto.PessoaDTO;
import com.api.rabbitmq.service.RabbitMQService;

@RestController
@RequestMapping({"/rabbitMQAPI"})
public class PessoaController {
	
	@Autowired
	private RabbitMQService rabbitMQService;
	
	@PostMapping(path="/incluirAssinc")
	@ResponseStatus(HttpStatus.OK)
	public void incluir(@RequestBody PessoaDTO pessoa){
		this.rabbitMQService.enviaMsgAssincrona(RabbitMQConstantes.FILA_INCLUIR, pessoa);
	}
	
	
	@GetMapping(path="/listar")
	public List<PessoaDTO> listar(){
		List<PessoaDTO> p = rabbitMQService.enviaMsgSincrona(RabbitMQConstantes.FILA_LISTAR, new PessoaDTO());
		return p;
	}
	
	@GetMapping(path="/listarPorNome")
	public List<PessoaDTO> listarPorNome(@RequestParam("nome") String nome){
		List<PessoaDTO> p = rabbitMQService.enviaMsgSincrona(RabbitMQConstantes.FILA_LISTAR_POR_NOME, nome);
		return p;
	}

}
