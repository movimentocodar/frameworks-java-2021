package br.com.codar.receitas.repository;

import br.com.codar.receitas.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    @Query(value = "SELECT * FROM RECEITAS r WHERE r.REVISAR = FALSE ORDER BY r.DATA_PUBLICACAO DESC",
    nativeQuery = true)
    List<Receita> findByRevisarFalseAndOrderByDateDesc();
}
