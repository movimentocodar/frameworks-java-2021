package br.com.codar.receitas.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NotFoundController implements ErrorController {
    @RequestMapping("/error")
    public String notFound(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("messageError404", "Página não encontrada!");
        return "redirect:/receitas/lista";
    }
}
