package br.com.biblioteca.controller.emprestimo;

import java.io.IOException;

import javax.sql.DataSource;

import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.service.EmprestimoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/emprestimo/edicao")
public class GetEmprestimoServlet extends HttpServlet {

    private EmprestimoService getEmprestimoService() {
        DataSource dataSource =
            (DataSource) getServletContext().getAttribute("dataSource");
        return new EmprestimoService(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Emprestimo emprestimo = getEmprestimoService()
            .getById(Long.valueOf(req.getParameter("id")));
        req.setAttribute("emprestimo", emprestimo);
        req.getRequestDispatcher("/emprestimo/form.jsp").forward(req, resp);
    }
}
