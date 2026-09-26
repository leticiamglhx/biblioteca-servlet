package br.com.biblioteca.controller.emprestimo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.service.EmprestimoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/emprestimos")
public class EmprestimoServlet extends HttpServlet {

    private EmprestimoService getEmprestimoService() {
        DataSource dataSource =
            (DataSource) getServletContext().getAttribute("dataSource");
        return new EmprestimoService(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Emprestimo> emprestimos = getEmprestimoService().getAll();
        req.setAttribute("emprestimos", emprestimos);
        req.getRequestDispatcher("/emprestimo/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        EmprestimoService emprestimoService = getEmprestimoService();
        String id = req.getParameter("id");
        boolean edicao = id != null && !id.isEmpty();

        Emprestimo emprestimo = edicao
            ? emprestimoService.getById(Long.valueOf(id))
            : new Emprestimo();
        emprestimo.setIdPessoa(Long.valueOf(req.getParameter("idPessoa")));
        emprestimo.setIdLivro(Long.valueOf(req.getParameter("idLivro")));
        emprestimo.setDataEmprestimo(
            LocalDate.parse(req.getParameter("dataEmprestimo"))
        );

        String dataDevolucao = req.getParameter("dataDevolucao");
        emprestimo.setDataDevolucao(
            dataDevolucao == null || dataDevolucao.trim().isEmpty()
                ? null
                : LocalDate.parse(dataDevolucao)
        );

        if (edicao) {
            emprestimoService.update(emprestimo);
        } else {
            emprestimoService.create(emprestimo);
        }
        resp.sendRedirect(req.getContextPath() + "/emprestimos");
    }
}
