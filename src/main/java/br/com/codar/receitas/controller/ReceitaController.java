package br.com.codar.receitas.controller;
import br.com.codar.receitas.model.Receita;
import br.com.codar.receitas.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping("lista")
    public String lista(Model model) {
        model.addAttribute("receitas", receitaService.listar());
        return "lista-receitas";
    }

    @GetMapping("nova")
    public String nova(Receita receita) {
        return "cadastro-receita";
    }

    @PostMapping
    public String salvar(Receita receita) {
        Receita receitaSalva = receitaService.salvar(receita);
        return "redirect:/receitas/detalhe/" + receitaSalva.getId();
    }

    @GetMapping("detalhe/{id}")
    public String detalhe(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("receita", receitaService.buscarPorId(id));
        return "detalhe-receita";
    }

}
