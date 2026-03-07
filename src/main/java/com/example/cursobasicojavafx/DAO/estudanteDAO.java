package com.example.cursobasicojavafx.DAO;

import com.example.cursobasicojavafx.Conexao;
import com.example.cursobasicojavafx.Estudante;
import com.example.cursobasicojavafx.Repositorio.EstudanteRepositorio;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class estudanteDAO implements EstudanteRepositorio {

    @Override
    public void porId() {

    }

    @Override
    public List<Estudante> buscarTodos() {
        return List.of();
    }

    @Override
    public void inserir() {

    }

    @Override
    public void inserir(Estudante estudante) {

        try {
            String sql = "INSERT INTO estudante (nome, idade, sexo) VALUES (?, ?, ?)";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            String sexo = String.valueOf(estudante.getSexo().charAt(0));
            ps.setString(1, estudante.getNome());
            ps.setInt(2, estudante.getIdade());
            ps.setString(3, sexo);
            ps.execute();

        } catch (SQLException ex) {

            System.out.println("Erro: " + ex.getMessage());
        }
    }

    @Override
    public void apagar() {

    }
}
