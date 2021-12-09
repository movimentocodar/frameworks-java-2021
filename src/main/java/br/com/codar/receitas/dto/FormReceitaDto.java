package br.com.codar.receitas.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.codar.receitas.model.Ingrediente;
import br.com.codar.receitas.model.Receita;

public class FormReceitaDto {
	
	@NotBlank
	private String nome;
	
	private String linkFoto;
	
	@NotBlank @Size(min = 20)
	private String modoPreparo;
	
	@NotNull @Min(10) @Max(360)
	private int tempoPreparo;
	
	@Min(1) @Max(50)
	private int rendimento;
	
	private Boolean revisar;
	
	@NotEmpty
	private List<Ingrediente> ingredientes;
		
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

	public Boolean getRevisar() {
		return revisar;
	}

	public void setRevisar(Boolean precisaRevisar) {
		this.revisar = precisaRevisar;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public Receita toReceita() {
		return new Receita(this.nome, this.linkFoto, this.modoPreparo, this.tempoPreparo, 
				this.rendimento, LocalDate.now(), this.revisar, this.ingredientes);
	}
	
}
