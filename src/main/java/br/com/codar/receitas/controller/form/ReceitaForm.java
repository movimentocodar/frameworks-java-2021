package br.com.codar.receitas.controller.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.codar.receitas.model.Ingrediente;
import br.com.codar.receitas.model.Receita;

public class ReceitaForm {

    private Long id;
    @NotEmpty(message = "Informe o nome da receita")
    @Length(min = 5, max = 20)
    private String nome;

    private String linkFoto;
    @NotNull(message = "Informe o tempo de preparo")
    @Range(min = 10, max = 360)

    private Integer tempoPreparo;
    @NotNull(message = "Informe o Rendimento")
    @Range(min = 1, max = 50)
    private Integer rendimento;

    @NotNull(message = "Informe o modo de preparo")
    @Length(min = 10, max = 360)
    private String modoPreparo;

    @Size(min = 1, message = "A receita deve conter pelo menos um ingrediente")
    private List<Ingrediente> ingredientes = new ArrayList<>();

    private Boolean revisar;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Integer tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public Integer getRendimento() {
        return rendimento;
    }

    public void setRendimento(Integer rendimento) {
        this.rendimento = rendimento;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }


    public Boolean getRevisar() {
        return revisar;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setRevisar(Boolean revisar) {
        this.revisar = revisar;
    }

    public Receita converte() {
        return new Receita(id, nome, linkFoto, tempoPreparo, rendimento, ingredientes, modoPreparo, revisar);
    }

    public void limparCampos(){
        this.nome = "";
        this.linkFoto = "";
        this.tempoPreparo = 0;
        this.rendimento = 0;
        this.ingredientes.clear();
        this.modoPreparo = "";
        this.revisar = true;
    }


}
