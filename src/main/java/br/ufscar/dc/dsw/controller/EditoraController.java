package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.EditoraDAO;
import br.ufscar.dc.dsw.domain.Editora;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/editoras")
public class EditoraController extends HttpServlet {

    private EditoraDAO dao = new EditoraDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String acao = req.getParameter("acao");

        try {
            if (acao == null || acao.equals("listar")) {
                List<Editora> lista = dao.getAll();
                req.setAttribute("editoras", lista);
                req.getRequestDispatcher("/editora/lista.jsp").forward(req, resp);

            } else if (acao.equals("novo")) {
                req.getRequestDispatcher("/editora/formulario.jsp").forward(req, resp);

            } else if (acao.equals("editar")) {
                Long id = Long.parseLong(req.getParameter("id"));
                Editora e = dao.getById(id);
                req.setAttribute("editora", e);
                req.getRequestDispatcher("/editora/formulario.jsp").forward(req, resp);

            } else if (acao.equals("excluir")) {
                Long id = Long.parseLong(req.getParameter("id"));
                dao.delete(id);
                resp.sendRedirect("editoras");
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        String nome = req.getParameter("nome");
        String cidade = req.getParameter("cidade");

        Editora e = new Editora(null, nome, cidade);

        try {
            if (id == null || id.isEmpty()) {
                dao.insert(e);
            } else {
                e.setId(Long.parseLong(id));
                dao.update(e);
            }

            resp.sendRedirect("editoras");

        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}