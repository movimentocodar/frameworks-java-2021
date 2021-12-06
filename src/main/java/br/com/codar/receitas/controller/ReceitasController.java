package br.com.codar.receitas.controller;

import br.com.codar.receitas.controller.dto.DetalheReceitaDto;
import br.com.codar.receitas.controller.dto.ListaReceitaDto;
import br.com.codar.receitas.controller.form.ReceitaForm;
import br.com.codar.receitas.model.Receita;

import br.com.codar.receitas.repository.IngredienteRepository;
import br.com.codar.receitas.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;


import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping(value = "/receitas", produces = "application/json")
public class ReceitasController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @GetMapping(
            value = "/nova",
            produces="application/json"
    )
    public String nova(Model model){
        ReceitaForm receitaForm = new ReceitaForm();
        model.addAttribute("receitaForm", receitaForm);
        return "receitas/nova";
    }

    @GetMapping("/lista")
    public String listaReceita(Model model){
        List<Receita> receitas = receitaRepository.findByRevisarFalseAndOrderByDateDesc();

        model.addAttribute("receitas", ListaReceitaDto.converter(receitas));
        return "receitas/lista";
    }

    @PostMapping(consumes="application/json")
    public String cadastrar(@RequestBody @Valid ReceitaForm receitaForm, BindingResult result, UriComponentsBuilder uriBuilder, Model model) {

        if(result.hasErrors()) {
            model.addAttribute("sucesso", false);
            return "receitas/nova";
        }

        Receita receita = receitaForm.converter(ingredienteRepository);
        receitaRepository.save(receita);

      /*
      ResponseEntity<ListaReceitaDto>
      URI uri = uriBuilder.path("/detalhe/{id}").buildAndExpand(receita.getId()).toUri();
        return ResponseEntity.created(uri).body(new ListaReceitaDto(receita));*/

        model.addAttribute("sucesso", true);
        ReceitaForm receitaFormNovo = new ReceitaForm();
        model.addAttribute("receitaForm", receitaFormNovo);
        return "receitas/nova";
    }

    @GetMapping("/detalhe/{id}")
    public String detalhar(@PathVariable Long id, Model model) {
        Optional<Receita> receita = receitaRepository.findById(id);
        if (receita.isPresent()) {
           model.addAttribute("receita", new DetalheReceitaDto(receita.get()));
            return "receitas/detalhe";
        }
        return "receitas/lista";
    }

  /*  @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/lista";
    }*/
}
