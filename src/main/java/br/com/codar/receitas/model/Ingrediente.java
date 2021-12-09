package br.com.codar.receitas.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ingredientes")
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@Min(1) @Max(1000)
	private int quantidade;
	
	@ManyToOne
	private Receita receita;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Medida medida;
	
	public Ingrediente() {}

	public Ingrediente(Long id, String nome, int quantidade, Receita receita,
			Medida medida) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.receita = receita;
		this.medida = medida;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Medida getMedida() {
		return medida;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}
}
