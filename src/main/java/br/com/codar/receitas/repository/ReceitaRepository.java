package br.com.codar.receitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.codar.receitas.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
	
	List<Receita> findAllByOrderByDataPublicacaoDesc();

}