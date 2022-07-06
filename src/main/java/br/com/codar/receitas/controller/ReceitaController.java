package br.com.codar.receitas.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import javax.validation.Valid;

import br.com.codar.receitas.controller.form.IngredienteForm;
import br.com.codar.receitas.controller.form.ReceitaForm;
import br.com.codar.receitas.model.Receita;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {
    private final ModelAndView modelAndView = new ModelAndView("cadastro-receita");
    private final ReceitaRepository receitaRepository;

    public ReceitaController(final ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    @GetMapping("/lista")
    public String lista(final Model model) {
        Iterable<Receita> receitas = receitaRepository.findAll();

        model.addAttribute("receitas", receitas);

        return "lista-receitas";

    }

    @GetMapping
    public ModelAndView nova() {
        return modelAndView;
    }

    @GetMapping("/nova")
    public String nova(final Model model) {
        model.addAttribute("receitaForm", new ReceitaForm());
        model.addAttribute("ingredienteForm", new IngredienteForm());
        return "cadastro-receita";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Valid final ReceitaForm receitaForm, final BindingResult result, final Model model) {
        if (result.hasErrors()){
            model.addAttribute(new IngredienteForm());
            return  "cadastro-receita";
        }
        Receita receita = receitaForm.converte();
        receitaRepository.save(receita);
        String sucesso = "Salvo com sucesso";
        receitaForm.limparCampos();
        model.addAttribute("sucesso", sucesso);
        model.addAttribute("receitaForm", receitaForm);
        return "cadastro-receita";

    }

    @GetMapping("/detalhe/{id}")
    public ModelAndView detalhe(@PathVariable("id") final Long id) {
        Optional<Receita> receita = receitaRepository.findById(id);
        ModelAndView modelAndView = new ModelAndView("detalhe-receita");
        modelAndView.addObject("receita", receita.orElse(null));
        return modelAndView;

    }

}