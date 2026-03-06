package com.example.cursobasicojavafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:postgresql://localhost:5432/estudante";
    private static final String User = "postgres";
    private static final String Pass = "1234";

    public static Connection obterConexao() throws SQLException {

        try {
            return DriverManager.getConnection(URL, User, Pass);
        } catch (SQLException e) {
            throw new SQLException("Erro ao obter conexão: " + e.getMessage());
        }
    }
    public static  void fecharConexao(Connection connection) throws SQLException {
        if(connection != null && !connection.isClosed()){
            connection.close();
        }
    }
}
