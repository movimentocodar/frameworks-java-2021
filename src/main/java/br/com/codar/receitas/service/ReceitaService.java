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

    public List<Receita> listar() {
        return repository.findAll();
    }
}
