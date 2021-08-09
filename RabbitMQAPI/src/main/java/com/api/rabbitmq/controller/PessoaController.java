package com.api.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Object> listar(){
		PessoaDTO pessoa = new PessoaDTO();
		Object p = rabbitMQService.enviaMsgSincrona(RabbitMQConstantes.FILA_LISTAR, pessoa);
		
		return new ResponseEntity<Object>(p, p!=null ? HttpStatus.OK : HttpStatus.GATEWAY_TIMEOUT);
	}
	
	@GetMapping(path="/listarPorNome")
	public ResponseEntity<Object> listarPorNome(@RequestParam("nome") String nome){
		PessoaDTO pessoa = new PessoaDTO();
		pessoa.nome = nome;
		Object p = rabbitMQService.enviaMsgSincrona(RabbitMQConstantes.FILA_LISTAR, pessoa);
		
		return new ResponseEntity<Object>(p, p!=null ? HttpStatus.OK : HttpStatus.GATEWAY_TIMEOUT);
	}
	
	@PostMapping(path="/gerarMsg")
	@ResponseStatus(HttpStatus.OK)
	public void gerarMsg() {
		for(int i=1; i<=100000; i++) {
			this.rabbitMQService.enviaMsgAssincrona(RabbitMQConstantes.FILA_DISP_MASSA, "---MENSAGEM " + i );
			System.out.println("---MENSAGEM " + i + " ENVIADA!!!!");
		}
	}

}
