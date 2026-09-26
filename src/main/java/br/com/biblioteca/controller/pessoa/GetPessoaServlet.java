package br.com.biblioteca.controller.pessoa;

import java.io.IOException;

import javax.sql.DataSource;

import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.service.PessoaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pessoa/edicao")
public class GetPessoaServlet extends HttpServlet{
    private PessoaService getPessoaService() {
        DataSource dataSource =
            (DataSource) getServletContext()
                .getAttribute("dataSource");
        return new PessoaService(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        Pessoa pessoaEdicao = getPessoaService().getById(Long.valueOf(req.getParameter("id")));
        req.setAttribute("pessoa", pessoaEdicao);
        req.getRequestDispatcher("/pessoas/form.jsp").forward(req, resp);
    }
    
}
