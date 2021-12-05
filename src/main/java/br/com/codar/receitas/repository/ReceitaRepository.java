package br.com.codar.receitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.codar.receitas.modelo.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

	Receita getById();

	List<Receita> findAllByOrderByDataPublicacaoDesc();

}
