package br.com.codar.receitas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.codar.receitas.form.ReceitaForm;
import br.com.codar.receitas.modelo.Receita;
import br.com.codar.receitas.repository.ReceitaRepository;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {

	@Autowired
	ReceitaRepository receitaRepository;

	@GetMapping("nova")
	public String nova(ReceitaForm receitaForm) {
		return "cadastro-receita";
	}

	@GetMapping("lista")
	public String lista(Model model) {
		List<Receita> receitas = receitaRepository.findAllByOrderByDataPublicacaoDesc();
		model.addAttribute("receitas", receitas);
		return "lista-receitas";
	}
	
	@PostMapping
	public String salvar(@Valid ReceitaForm receitaForm, RedirectAttributes attributes) {
		Receita receita = receitaRepository.save(receitaForm.converter());
		attributes.addFlashAttribute("sucesso", "Receita salva!");
		return "redirect:/receitas/nova";
	}
	
	@GetMapping("detalhe/{id}")
	public String detalhe(@PathVariable Long id, Model model) {
		model.addAttribute("receita", receitaRepository.findById(id).get());
		return "detalhe-receita";
	}
}