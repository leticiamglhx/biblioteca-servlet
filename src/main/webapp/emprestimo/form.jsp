<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="br.com.biblioteca.model.Emprestimo" %>
<%
    Emprestimo emprestimo = (Emprestimo) request.getAttribute("emprestimo");
    boolean edicao = emprestimo != null;
%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= edicao ? "Editar Empréstimo" : "Cadastrar Empréstimo" %></title>
</head>
<body>
    <h1><%= edicao ? "Editar Empréstimo" : "Cadastrar Empréstimo" %></h1>
    <form action="<%= request.getContextPath() %>/emprestimos" method="post">
        <% if (edicao) { %>
            <input type="hidden" name="id" value="<%= emprestimo.getId() %>">
        <% } %>
        <label for="idPessoa">ID da Pessoa:</label>
        <input type="number" id="idPessoa" name="idPessoa" min="1" step="1" required
               value="<%= edicao ? emprestimo.getIdPessoa() : "" %>">
        <br>
        <label for="idLivro">ID do Livro:</label>
        <input type="number" id="idLivro" name="idLivro" min="1" step="1" required
               value="<%= edicao ? emprestimo.getIdLivro() : "" %>">
        <p>Informe os IDs de uma pessoa e de um livro já cadastrados.</p>
        <label for="dataEmprestimo">Data do Empréstimo:</label>
        <input type="date" id="dataEmprestimo" name="dataEmprestimo" required
               value="<%= edicao ? emprestimo.getDataEmprestimo() : "" %>">
        <br>
        <label for="dataDevolucao">Data de Devolução:</label>
        <input type="date" id="dataDevolucao" name="dataDevolucao"
               value="<%= edicao && emprestimo.getDataDevolucao() != null ? emprestimo.getDataDevolucao() : "" %>">
        <br>
        <input type="submit" value="<%= edicao ? "Salvar Alterações" : "Cadastrar Empréstimo" %>">
    </form>
    <p><a href="<%= request.getContextPath() %>/emprestimos">Voltar para a lista</a></p>
</body>
</html>
