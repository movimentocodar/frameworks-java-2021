package br.com.codar.receitas.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate dataPublicacao = LocalDate.now();
    private String modoPreparo;
    private Boolean revisar;

}
