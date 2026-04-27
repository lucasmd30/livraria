package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class GenericDAO {

    private final String url = "jdbc:postgresql://localhost:5432/livraria";
    private final String user = "postgres";
    private final String password = "postgres";

    public Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}