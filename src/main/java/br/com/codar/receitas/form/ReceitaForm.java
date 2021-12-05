package br.com.codar.receitas.form;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.codar.receitas.modelo.Ingrediente;
import br.com.codar.receitas.modelo.Receita;

public class ReceitaForm {

	@NotNull
	@NotBlank
	private String nome;

	private String linkFoto;

	@NotNull
	@NotBlank
	@Min(10)
	@Max(360)
	private Integer tempoPreparo;

	@NotNull
	@NotBlank
	@Min(1)
	@Max(50)
	private Integer rendimento;

	@NotNull
	@NotBlank
	@Min(20)
	private String modoPreparo;

	@Valid
	private List<Ingrediente> ingredientes;

	private Boolean revisar;

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

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Boolean getRevisar() {
		return revisar;
	}

	public void setRevisar(Boolean revisar) {
		this.revisar = revisar;
	}

	public Receita converter() {
		return new Receita(nome, linkFoto, tempoPreparo, rendimento, modoPreparo, ingredientes, revisar);
	}

}
