<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.biblioteca.model.Emprestimo" %>
<%
    List<Emprestimo> emprestimos = (List<Emprestimo>) request.getAttribute("emprestimos");
    if (emprestimos == null) {
        response.sendRedirect(request.getContextPath() + "/emprestimos");
        return;
    }
%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Empréstimos</title>
</head>
<body>
    <h1>Empréstimos</h1>
    <p><a href="<%= request.getContextPath() %>/emprestimo/form.jsp">Cadastrar novo empréstimo</a></p>
    <% if (emprestimos.isEmpty()) { %>
        <p>Nenhum empréstimo cadastrado.</p>
    <% } else { %>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>ID da Pessoa</th>
                    <th>ID do Livro</th>
                    <th>Data do Empréstimo</th>
                    <th>Data de Devolução</th>
                    <th colspan="2">Ações</th>
                </tr>
            </thead>
            <tbody>
            <% for (Emprestimo emprestimo : emprestimos) { %>
                <tr>
                    <td><%= emprestimo.getId() %></td>
                    <td><%= emprestimo.getIdPessoa() %></td>
                    <td><%= emprestimo.getIdLivro() %></td>
                    <td><%= emprestimo.getDataEmprestimo() %></td>
                    <td><%= emprestimo.getDataDevolucao() != null ? emprestimo.getDataDevolucao() : "Não devolvido" %></td>
                    <td><a href="<%= request.getContextPath() %>/emprestimo/edicao?id=<%= emprestimo.getId() %>">Editar</a></td>
                    <td><a href="<%= request.getContextPath() %>/emprestimo/excluir?id=<%= emprestimo.getId() %>">Excluir</a></td>
                </tr>
            <% } %>
            </tbody>
        </table>
    <% } %>
</body>
</html>
