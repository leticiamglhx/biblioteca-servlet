package br.com.biblioteca.model;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Pessoa extends GenericEntity{

    private String nome;

    private LocalDate dataNascimento;
}

