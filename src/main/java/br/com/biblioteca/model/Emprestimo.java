package br.com.biblioteca.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data 
@EqualsAndHashCode(callSuper = true)
public class Emprestimo extends GenericEntity {
    private Long idPessoa;
    private Long idLivro;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
}
