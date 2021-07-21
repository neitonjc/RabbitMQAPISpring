package com.api.rabbitmq.dto;

import java.io.Serializable;

public class PessoaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1280128480234958871L;
	
	public String nome;
	public String email;
	public String cep;
	public String rua;
	public String bairro;
	public String cidade;
	public String uf;
	
	public PessoaDTO(String nome, String email, String cep, String rua, String bairro, String cidade, String uf) {
		super();
		this.nome = nome;
		this.email = email;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	
}
