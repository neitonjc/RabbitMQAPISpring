package com.api.consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.consumer.model.Pessoa;
import com.api.consumer.repository.PessoaRepository;
import com.api.rabbitmq.dto.RetornoCepDTO;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository rep;
	
	public List<Pessoa> listar() {
		return rep.findAll();
	}

	public Pessoa listarPorId(Integer cod) {
		return rep.findById(cod).get();
	}

	public Pessoa incluir(Pessoa pessoa) {
		montaObj(pessoa);
		return rep.save(pessoa);
	}


	public Pessoa editar(Pessoa pessoa) {
		montaObj(pessoa);
		return rep.save(pessoa);
	}

	public void excluir(Integer cod) {
		rep.delete(new Pessoa(cod));
	}

	public List<Pessoa> listarPorNome(String nome) {
		return rep.findByName(nome.trim().toUpperCase());
	}
	
	private void montaObj(Pessoa pessoa) {
		RetornoCepDTO o = consumerCEP(pessoa.getCep());
		pessoa.setRua(o.logradouro);
		pessoa.setCep(o.cep);
		pessoa.setBairro(o.bairro);
		pessoa.setCidade(o.localidade);
		pessoa.setUf(o.uf);
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
