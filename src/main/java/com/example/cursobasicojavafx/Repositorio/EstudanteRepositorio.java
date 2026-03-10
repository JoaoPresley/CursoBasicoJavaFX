package com.example.cursobasicojavafx.Repositorio;

import com.example.cursobasicojavafx.Estudante;

import java.util.List;

public interface EstudanteRepositorio {

    public Estudante porId(long id);

    public List <Estudante> buscarTodos();

    void inserir(Estudante estudante);

    public void apagar(Long id);
}
