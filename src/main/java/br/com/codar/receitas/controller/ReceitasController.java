package br.com.codar.receitas.controller;

import br.com.codar.receitas.controller.dto.DetalheReceitaDto;
import br.com.codar.receitas.controller.dto.ListaReceitaDto;
import br.com.codar.receitas.controller.form.ReceitaForm;
import br.com.codar.receitas.model.Ingrediente;
import br.com.codar.receitas.model.Medida;
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

    @ResponseBody
    public List<ListaReceitaDto> listaReceita(){

        Ingrediente chocolate = new Ingrediente("Chocolate", 200, Medida.GRAMA);
        Ingrediente farinha = new Ingrediente("Farinha", 500, Medida.GRAMA);
        Ingrediente ovo = new Ingrediente("Ovos", 2, Medida.UNIDADE);
        Ingrediente leite = new Ingrediente("Leite", 100, Medida.MILILITRO);
        Ingrediente acucar = new Ingrediente("Açucar", 100, Medida.GRAMA);

        ingredienteRepository.save(chocolate);
        ingredienteRepository.save(farinha);
        ingredienteRepository.save(ovo);
        ingredienteRepository.save(leite);
        ingredienteRepository.save(acucar);


        Receita brownie = new Receita("Brownie de Chocolate",
                "https://img.estadao.com.br/fotos/crop/1200x1200/resources/jpg/7/0/1519841184607.jpg",
                40, 8,
                "Em uma tigela coloque os ovos e o açúcar e bata com a ajuda de fouet ou garfo, em seguida adicione chocolate e depois adicione a farinha até que fique homogênea; Despeje a massa em uma forma untada e asse em forno pré-aquecido a 180ºC por 35 minutos.",
                false, ingredienteRepository.findAll());

        receitaRepository.save(brownie);


        List<Receita> receitas = receitaRepository.findAll();
        return ListaReceitaDto.converter(receitas);
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
    public ResponseEntity<DetalheReceitaDto> detalhar(@PathVariable Long id) {
        Optional<Receita> receita = receitaRepository.findById(id);
        if (receita.isPresent()) {
            return ResponseEntity.ok(new DetalheReceitaDto(receita.get()));
        }

        return ResponseEntity.notFound().build();
    }


}
