package br.com.codar.receitas.controller;

import br.com.codar.receitas.controller.dto.DetalheReceitaDto;
import br.com.codar.receitas.controller.dto.ListaReceitaDto;
import br.com.codar.receitas.controller.form.ReceitaForm;
import br.com.codar.receitas.model.Receita;

import br.com.codar.receitas.repository.IngredienteRepository;
import br.com.codar.receitas.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @PostMapping
    public String cadastrar(@Valid ReceitaForm receitaForm, BindingResult result, Model model) {

        if(result.hasErrors()) {
            model.addAttribute("sucesso", false);
            return "receitas/nova";
        }

        Receita receita = receitaForm.converter(ingredienteRepository);
        receitaRepository.save(receita);

        model.addAttribute("sucesso", "Receita inserida com sucesso!");
        ReceitaForm receitaFormNovo = new ReceitaForm();
        model.addAttribute("receitaForm", receitaFormNovo);
        return "receitas/nova";
    }

    @GetMapping("/detalhe/{id}")
    public String detalhar(@PathVariable Long id, Model model) {
        Optional<Receita> receita = receitaRepository.findById(id);
        if (!receita.isEmpty()) {
           model.addAttribute("receita", new DetalheReceitaDto(receita.get()));
            return "receitas/detalhe";
        }
        return "receitas/lista";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/receitas/lista";
    }
}
