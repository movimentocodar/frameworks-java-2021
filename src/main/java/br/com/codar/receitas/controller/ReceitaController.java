package br.com.codar.receitas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.codar.receitas.dto.FormReceitaDto;
import br.com.codar.receitas.repository.ReceitaRepository;

@Controller
@RequestMapping("receitas")
public class ReceitaController {
	
	@Autowired
	private ReceitaRepository receitaRepository;

	@PostMapping
	public String cadastrarReceita(@Valid FormReceitaDto formReceitaDto, 
			BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors())
            return "cadastro-receita";
		
		this.receitaRepository.save(formReceitaDto.toReceita());
        attributes.addFlashAttribute("sucesso", "Receita salva!");
        
        return "redirect:receitas/lista";
        
	}	
	
	@GetMapping("nova")
	public String mostrarFormulario(FormReceitaDto formReceitaDto) {
		return "cadastro-receita";
	}
	
	@GetMapping("lista")
	public String listar(Model model) {
		model.addAttribute("receitas", this.receitaRepository.findAll());
		return "lista-receitas";
	}
	
	@GetMapping("detalhe/{id}")
    public String mostrarDetalhes(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("receita", this.receitaRepository.findById(id).get());
        return "detalhe-receita";
    }
	
}
