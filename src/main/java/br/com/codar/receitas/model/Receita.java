package br.com.codar.receitas.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Receita {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Lob
    private String linkFoto;
    private Integer tempoPreparo;
    private Integer rendimento;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ingredientes> ingredientes;
    private LocalDateTime dataPublicacao = LocalDateTime.now();
    @Column(length = 1000)
    private String modoPreparo;
    private Boolean revisar;

    public Receita (String nome, String linkFoto, Integer tempoPreparo, Integer rendimento, List<Ingredientes> ingredientes, String modoPreparo, Boolean revisar) {
        setNome(nome);
        setLinkFoto(linkFoto);
        setTempoPreparo(tempoPreparo);
        setRendimento(rendimento);
        setIngredientes(ingredientes);
        setModoPreparo(modoPreparo);
        setRevisar(revisar);
    }

}
