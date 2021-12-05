package br.com.codar.receitas.model;

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
	private int tempoPreparo;
	private int rendimento;
	private LocalDateTime dataPublicacao = LocalDateTime.now();
	private String modoPreparo;
	private Boolean precisaRevisar;
	
	@OneToMany(mappedBy = "receita")
	private List<Ingredientes> ingredientes;
	
	public Receita() {
		
	}	
	
	public Receita(String nome, String linkFoto, int tempoPreparo, int rendimento, List<Ingredientes> ingredientes, String modoPreparo,
			Boolean precisaRevisar) {
		setNome(nome);
		setLinkFoto(linkFoto);
		setTempoPreparo(tempoPreparo);
		setRendimento(rendimento);
		setIngrediente(ingredientes);
		setModoPreparo(modoPreparo);
		setPrecisaRevisar(precisaRevisar);		
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Ingredientes> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingredientes> ingredientes) {
		this.ingredientes = ingredientes;
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
	public LocalDateTime getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(LocalDateTime dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	public List<Ingredientes> getIngrediente() {
		return ingredientes;
	}

	public void setIngrediente(List<Ingredientes> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Boolean getPrecisaRevisar() {
		return precisaRevisar;
	}

	public void setPrecisaRevisar(Boolean precisaRevisar) {
		this.precisaRevisar = precisaRevisar;
	}
	
	

}
