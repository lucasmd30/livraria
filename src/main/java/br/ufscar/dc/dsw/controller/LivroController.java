package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.LivroDAO;
import br.ufscar.dc.dsw.domain.Livro;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/livros")
public class LivroController extends HttpServlet {

    private LivroDAO dao = new LivroDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String acao = req.getParameter("acao");

        try {
            if (acao == null || acao.equals("listar")) {
                List<Livro> lista = dao.getAll();
                req.setAttribute("livros", lista);
                req.getRequestDispatcher("/livro/lista.jsp").forward(req, resp);

            } else if (acao.equals("novo")) {
                req.getRequestDispatcher("/livro/formulario.jsp").forward(req, resp);

            } else if (acao.equals("editar")) {
                Long id = Long.parseLong(req.getParameter("id"));
                Livro livro = dao.getById(id);
                req.setAttribute("livro", livro);
                req.getRequestDispatcher("/livro/formulario.jsp").forward(req, resp);

            } else if (acao.equals("excluir")) {
                Long id = Long.parseLong(req.getParameter("id"));
                dao.delete(id);
                resp.sendRedirect("livros");
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        String titulo = req.getParameter("titulo");
        String autor = req.getParameter("autor");
        Float preco = Float.parseFloat(req.getParameter("preco"));

        Livro livro = new Livro(null, titulo, autor, preco);

        try {
            if (id == null || id.isEmpty()) {
                dao.insert(livro);
            } else {
                livro.setId(Long.parseLong(id));
                dao.update(livro);
            }

            resp.sendRedirect("livros");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}