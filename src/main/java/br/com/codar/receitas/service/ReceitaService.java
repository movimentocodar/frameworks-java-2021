package br.com.codar.receitas.service;

import br.com.codar.receitas.model.Receita;
import br.com.codar.receitas.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {
    @Autowired
    private ReceitaRepository repository;

    public List<Receita> listarSortData() {
        return repository.findAllByOrderByDataPublicacaoDesc();
    }

    public Receita salvar(Receita receita) {
        return repository.save(receita);
    }

    public Receita buscarPorId(Long id) {
        return repository.findById(id).get();
    }
}
