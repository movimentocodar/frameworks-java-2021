package br.com.codar.receitas.dto;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.codar.receitas.model.Ingredientes;
import br.com.codar.receitas.model.Receita;

public class RequisicaoNovaReceita {
	
	@NotBlank
	private String nome;
	
	private String linkFoto;
	
	@NotNull @Min(10) @Max(360)
	private int tempoPreparo;
	
	@NotNull @Min(1) @Max(50)
	private int rendimento;
	
	@NotEmpty
	private List<Ingredientes> ingredientes;
	
	@NotBlank @Size(min = 20)
	private String modoPreparo;	
	private Boolean precisaRevisar;
	
	public Receita toReceita() {
		return new Receita(nome, linkFoto, tempoPreparo, rendimento, ingredientes, modoPreparo, precisaRevisar);
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

	public int getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(int tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public int getRendimento() {
		return rendimento;
	}

	public void setRendimento(int rendimento) {
		this.rendimento = rendimento;
	}

	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	public Boolean getPrecisaRevisar() {
		return precisaRevisar;
	}

	public void setPrecisaRevisar(Boolean precisaRevisar) {
		this.precisaRevisar = precisaRevisar;
	}

	public List<Ingredientes> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingredientes> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
	
}
