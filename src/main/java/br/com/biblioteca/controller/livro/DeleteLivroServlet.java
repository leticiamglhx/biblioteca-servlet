package br.com.biblioteca.controller.livro;

import java.io.IOException;

import javax.sql.DataSource;

import br.com.biblioteca.model.Livro;
import br.com.biblioteca.service.LivroService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet ("/livro/deletar")
public class DeleteLivroServlet extends HttpServlet{
    private LivroService getLivroService() {
        DataSource dataSource =
            (DataSource) getServletContext()
                .getAttribute("dataSource");
        return new LivroService(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        Livro livroDelete = getLivroService().getById(Long.valueOf(req.getParameter("id")));

        getLivroService().delete(livroDelete);

        resp.sendRedirect(req.getContextPath() + "/livros");
    }
}
