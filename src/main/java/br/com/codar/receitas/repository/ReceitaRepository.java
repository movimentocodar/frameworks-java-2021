package br.com.codar.receitas.repository;

import br.com.codar.receitas.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findByRevisarFalse();
}
