package br.com.codar.receitas.repository;

import br.com.codar.receitas.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

}
