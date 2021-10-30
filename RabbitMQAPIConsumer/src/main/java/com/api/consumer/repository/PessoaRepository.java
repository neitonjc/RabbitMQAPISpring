package com.api.consumer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.consumer.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	@Query("select e from Pessoa e where e.nome like %:nome%")
	List<Pessoa> findByName(@Param("nome") String nome); 
}
