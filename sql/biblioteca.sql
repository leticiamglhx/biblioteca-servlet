CREATE DATABASE biblioteca;

USE biblioteca;

-- =========================
-- TABELA PESSOA
-- =========================

CREATE TABLE `pessoa` (
  `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nome` varchar(255) NOT NULL,
  `dataNascimento` date NOT NULL,
  `quemCadastrou` bigint DEFAULT NULL,
  `quemAlterouAUltimavez` bigint DEFAULT NULL,
  `dataCadastro` date DEFAULT NULL,
  `dataUltimaAlteracao` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- =========================
-- TABELA LIVRO
-- =========================

CREATE TABLE livro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    isbn VARCHAR(20) UNIQUE,
    anoPublicacao INT
);

-- =========================
-- TABELA EMPRESTIMO
-- =========================

CREATE TABLE emprestimo (
    id INT AUTO_INCREMENT PRIMARY KEY,

    idPessoa BIGINT NOT NULL,
    idLivro INT NOT NULL,

    dataEmprestimo DATE NOT NULL,
    dataDevolucao DATE,

    CONSTRAINT fk_emprestimo_pessoa
        FOREIGN KEY (idPessoa)
        REFERENCES pessoa(id),

    CONSTRAINT fk_emprestimo_livro
        FOREIGN KEY (idLivro)
        REFERENCES livro(id)
);