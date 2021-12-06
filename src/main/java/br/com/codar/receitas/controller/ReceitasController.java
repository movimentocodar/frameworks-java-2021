package br.com.codar.receitas.controller;

import br.com.codar.receitas.controller.dto.DetalheReceitaDto;
import br.com.codar.receitas.controller.dto.ListaReceitaDto;
import br.com.codar.receitas.controller.form.ReceitaForm;
import br.com.codar.receitas.model.Receita;

import br.com.codar.receitas.repository.IngredienteRepository;
import br.com.codar.receitas.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/receitas")
public class ReceitasController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @GetMapping("/nova")
    public String nova(Model model){
        ReceitaForm receita = new ReceitaForm();
        model.addAttribute("receita", receita);
        return "receitas/nova";
    }

    @GetMapping("/lista")
    public String listaReceita(Model model){
        List<Receita> receitas = receitaRepository.findByRevisarFalse();

        model.addAttribute("receitas", ListaReceitaDto.converter(receitas));
        return "receitas/lista";
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ListaReceitaDto> cadastrar(@RequestBody @Valid ReceitaForm receitaForm, BindingResult result, UriComponentsBuilder uriBuilder) {
        Receita receita = receitaForm.converter(ingredienteRepository);
        receitaRepository.save(receita);

        URI uri = uriBuilder.path("/detalhe/{id}").buildAndExpand(receita.getId()).toUri();
        return ResponseEntity.created(uri).body(new ListaReceitaDto(receita));
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
