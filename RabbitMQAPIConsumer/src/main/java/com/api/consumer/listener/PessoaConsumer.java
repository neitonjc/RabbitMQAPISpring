package com.api.consumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.consumer.constantes.RabbitMQConstantes;
import com.api.rabbitmq.dto.PessoaDTO;
import com.api.rabbitmq.dto.RetornoCepDTO;

@Component
public class PessoaConsumer {
	
	@RabbitListener(queues = RabbitMQConstantes.FILA_1)
	private void consumidor(PessoaDTO pessoa) throws Exception {
		if(pessoa.nome.isEmpty())
			throw new RuntimeException(">>>>>>>>>>>--ERRO--<<<<<<<<<<<");
		
		System.out.println("---------");
		System.out.println(pessoa.nome);
		System.out.println(pessoa.email);
		System.out.println(pessoa.cep);
		System.out.println("---------");
	}
	
	@RabbitListener(queues = RabbitMQConstantes.FILA_2)
	private PessoaDTO consumidorComRetorno(PessoaDTO pessoa) throws Exception {
		if(pessoa.nome.isEmpty())
			throw new RuntimeException(">>>>>>>>>>>--ERRO--<<<<<<<<<<<");
		
		pessoa.nome = pessoa.nome.toUpperCase();
		pessoa.email = pessoa.email.toLowerCase();
		
		montaObj(pessoa);
		
		return pessoa;
	}

	private void montaObj(PessoaDTO pessoa) {
		RetornoCepDTO o = consumerCEP(pessoa.cep);
		pessoa.rua = o.logradouro;
		pessoa.cep = o.cep;
		pessoa.bairro = o.bairro;
		pessoa.cidade = o.localidade;
		pessoa.uf = o.uf;
	}
	
	public RetornoCepDTO consumerCEP(String cep){
		RestTemplate template = new RestTemplate();
		
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("viacep.com.br/")
				.path("ws/"+cep+"/json/")
				.queryParam ("fields", "all")
				.build();
		
		return template.getForEntity(uri.toUriString(), RetornoCepDTO.class).getBody();
	}

}
