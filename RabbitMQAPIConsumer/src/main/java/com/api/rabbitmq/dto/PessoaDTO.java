package com.api.rabbitmq.dto;

import java.io.Serializable;
import java.sql.Date;

public class PessoaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1280128480234958871L;
	
	public String nome;
	public String email;
	public String cep;
	public Date dtNasc;
}
