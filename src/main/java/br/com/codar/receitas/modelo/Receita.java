package br.com.codar.receitas.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String linkFoto;
	private Integer tempoPreparo;
	private Integer rendimento;
	private String modoPreparo;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Ingrediente> ingredientes;

	private Boolean revisar;
	private LocalDateTime dataPublicacao = LocalDateTime.now();

	public Receita() {
	}

	public Receita(String nome, String linkFoto, Integer tempoPreparo, Integer rendimento, String modoPreparo,
			List<Ingrediente> ingredientes, Boolean revisar) {
		this.nome = nome;
		this.linkFoto = linkFoto;
		this.tempoPreparo = tempoPreparo;
		this.rendimento = rendimento;
		this.modoPreparo = modoPreparo;
		this.ingredientes = ingredientes;
		this.revisar = revisar;
	}

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

	public LocalDateTime getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDateTime dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

}
