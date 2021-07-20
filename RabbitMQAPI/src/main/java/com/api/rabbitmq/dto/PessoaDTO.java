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
}
