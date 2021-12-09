package br.com.codar.receitas.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "receitas")
public class Receita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String linkFoto;
	private String modoPreparo;
	
	private int tempoPreparo;
	private int rendimento;
	
	private LocalDate dataPublicacao = LocalDate.now();
	
	private Boolean revisar;
	
	@OneToMany(mappedBy = "receita")
	private List<Ingrediente> ingredientes;
	
	public Receita() {}	
	
	public Receita(String nome, String linkFoto, String modoPreparo, int tempoPreparo, 
			int rendimento, LocalDate dataPublicacao, Boolean revisar, 
			List<Ingrediente> ingredientes) {
		this.nome = nome;
		this.linkFoto = linkFoto;
		this.modoPreparo = modoPreparo;
		this.tempoPreparo = tempoPreparo;
		this.rendimento = rendimento;
		this.dataPublicacao = dataPublicacao;
		this.revisar = revisar;
		this.ingredientes = ingredientes;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public String getModoPreparo() {
		return modoPreparo;
	}

	public int getTempoPreparo() {
		return tempoPreparo;
	}

	public int getRendimento() {
		return rendimento;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Boolean getRevisar() {
		return revisar;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

}
