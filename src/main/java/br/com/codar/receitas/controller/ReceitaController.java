package br.com.codar.receitas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.codar.receitas.dto.RequisicaoNovaReceita;
import br.com.codar.receitas.model.Receita;
import br.com.codar.receitas.repository.ReceitaRepository;

@Controller
@RequestMapping("receitas")
public class ReceitaController {
	
	@Autowired
	private ReceitaRepository receitaRepository;

	@GetMapping("nova")
	public String formulario(RequisicaoNovaReceita requisicaoNovaReceita) {
		return "cadastro-receita";
	}
	
	@GetMapping("lista")
	public String listar(Model model) {
		List<Receita> receitas = receitaRepository.findAll();
		model.addAttribute("receitas", receitas);
		return "lista-receitas";
	}
	
	@PostMapping
	public String salvar(@Valid RequisicaoNovaReceita requisicaoNovaReceita, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
            return "cadastro-receita";
        }
        Receita receita = requisicaoNovaReceita.toReceita();
        receitaRepository.save(receita);
        attributes.addFlashAttribute("sucesso", "Receita salva com sucesso!");
        return "redirect:/nova";
	}
	
	@GetMapping("detalhe/{id}")
    public String detalhe(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("receita", receitaRepository.findById(id).get());
        return "detalhe-receita";
    }
	
}
