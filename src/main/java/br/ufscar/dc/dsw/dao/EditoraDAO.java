package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Editora;

import java.sql.*;
import java.util.*;

public class EditoraDAO extends GenericDAO {

    public void insert(Editora e) throws Exception {
        String sql = "INSERT INTO editora (nome, cidade) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getCidade());
            stmt.executeUpdate();
        }
    }

    public List<Editora> getAll() throws Exception {
        List<Editora> lista = new ArrayList<>();

        String sql = "SELECT * FROM editora";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Editora(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("cidade")
                ));
            }
        }

        return lista;
    }

    public Editora getById(Long id) throws Exception {
        String sql = "SELECT * FROM editora WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Editora(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("cidade")
                );
            }
        }

        return null;
    }

    public void update(Editora e) throws Exception {
        String sql = "UPDATE editora SET nome=?, cidade=? WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getCidade());
            stmt.setLong(3, e.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(Long id) throws Exception {
        String sql = "DELETE FROM editora WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}