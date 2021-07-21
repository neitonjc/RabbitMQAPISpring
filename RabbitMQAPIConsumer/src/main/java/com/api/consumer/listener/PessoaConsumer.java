package com.api.consumer.listener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.consumer.constantes.RabbitMQConstantes;
import com.api.consumer.model.Pessoa;
import com.api.consumer.service.PessoaService;
import com.api.rabbitmq.dto.PessoaDTO;

@Component
public class PessoaConsumer {
	
	@Autowired
	PessoaService service;
	
	@RabbitListener(queues = RabbitMQConstantes.FILA_INCLUIR)
	private void incluir(PessoaDTO pessoa) throws Exception {
		service.incluir(new Pessoa(null, pessoa.nome, pessoa.email, pessoa.cep));
		
		System.out.println("----SUCESSO!!!!-----");
	}
	
	@RabbitListener(queues = RabbitMQConstantes.FILA_LISTAR)
	private List<PessoaDTO> listarPessoas(PessoaDTO pessoa) throws Exception {
		List<Pessoa> pessoas = service.listar();
		List<PessoaDTO> listaRetorno = new ArrayList<PessoaDTO>(); 
		for (Pessoa p : pessoas) {
			listaRetorno.add(new PessoaDTO(p.getNome(), 
										   p.getEmail(), 
										   p.getCep(), 
										   p.getRua(), 
										   p.getBairro(), 
										   p.getCidade(), 
										   p.getUf()));
		}
		
		return listaRetorno;
	}
	
	@RabbitListener(queues = RabbitMQConstantes.FILA_LISTAR_POR_NOME)
	private List<PessoaDTO> listarPessoas(String nome) throws Exception {
		List<Pessoa> pessoas = service.listarPorNome(nome);
		List<PessoaDTO> listaRetorno = new ArrayList<PessoaDTO>(); 
		for (Pessoa p : pessoas) {
			listaRetorno.add(new PessoaDTO(p.getNome(), 
										   p.getEmail(), 
										   p.getCep(), 
										   p.getRua(), 
										   p.getBairro(), 
										   p.getCidade(), 
										   p.getUf()));
		}
		
		return listaRetorno;
	}
	

}
