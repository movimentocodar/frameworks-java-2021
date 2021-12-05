package br.com.codar.receitas.controller.form;

import br.com.codar.receitas.controller.dto.IngredienteDto;
import br.com.codar.receitas.model.Ingrediente;
import br.com.codar.receitas.model.Receita;
import br.com.codar.receitas.repository.IngredienteRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReceitaForm {

    @NotNull @NotEmpty
    private String nome;
    private String linkFoto;
    @NotNull @NotEmpty @Min(10) @Max(360)
    private Integer tempoPreparo;
    @NotNull @NotEmpty @Min(1) @Max(50)
    private Integer rendimento;
    @NotNull @NotEmpty @Length(min = 20)
    private String modoPreparo;
    private Boolean revisar;
    @NotNull @NotEmpty
    private List<IngredienteForm> ingredientes;

    public Receita converter(IngredienteRepository ingredienteRepository) {
        List<Ingrediente> listaIngredientes = new ArrayList<>();
        this.ingredientes.forEach(i -> listaIngredientes.add(i.converter()));
        listaIngredientes.forEach(i -> ingredienteRepository.save(i));
        return new Receita(this.nome, this.linkFoto, this.tempoPreparo, this.rendimento, this.modoPreparo, this.revisar, listaIngredientes);
    }
}
