package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO extends GenericDAO {

    public void insert(Livro livro) throws Exception {
        String sql = "INSERT INTO livro (titulo, autor, preco) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setFloat(3, livro.getPreco());

            stmt.executeUpdate();
        }
    }

    public List<Livro> getAll() throws Exception {
        List<Livro> lista = new ArrayList<>();

        String sql = "SELECT * FROM livro";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Livro(
                        rs.getLong("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getFloat("preco")
                ));
            }
        }

        return lista;
    }

    public Livro getById(Long id) throws Exception {
        String sql = "SELECT * FROM livro WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Livro(
                        rs.getLong("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getFloat("preco")
                );
            }
        }

        return null;
    }

    public void update(Livro livro) throws Exception {
        String sql = "UPDATE livro SET titulo=?, autor=?, preco=? WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setFloat(3, livro.getPreco());
            stmt.setLong(4, livro.getId());

            stmt.executeUpdate();
        }
    }

    public void delete(Long id) throws Exception {
        String sql = "DELETE FROM livro WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}