package br.com.codar.receitas.controller;
import br.com.codar.receitas.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

}
