package br.com.codar.receitas.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.codar.receitas.model.Receita;
@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

}
