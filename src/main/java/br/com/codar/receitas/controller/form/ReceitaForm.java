package br.com.codar.receitas.controller.form;

import br.com.codar.receitas.model.Ingredientes;
import br.com.codar.receitas.model.Receita;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
public class ReceitaForm {
    @NotNull @NotEmpty
    private String nome;

    private String linkFoto;

    @NotNull @Min(10) @Max(360)
    private Integer tempoPreparo;

    @NotNull @Min(1) @Max(50)
    private Integer rendimento;

    @NotEmpty
    private List<Ingredientes> ingredientes;

    @NotNull @Size(min = 20, max = 1000)
    private String modoPreparo;
    private Boolean revisar;

    public Receita converter() {
        return new Receita(nome, linkFoto, tempoPreparo, rendimento, ingredientes, modoPreparo, revisar);
    }

}
