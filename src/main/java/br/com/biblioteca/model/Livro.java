package br.com.biblioteca.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data //criar automaticamente os métodos getters e setters
@EqualsAndHashCode(callSuper = true) //gerar equals e hashcode considerando a superclasse
public class Livro extends GenericEntity {
    private String titulo;
    private String autor;
    private String isbn;
    private Integer anoPublicacao;
}
