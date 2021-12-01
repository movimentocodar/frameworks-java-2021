package br.com.codar.receitas.repository;

import br.com.codar.receitas.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    List<Receita> findAllByOrderByDataPublicacaoDesc();
}
