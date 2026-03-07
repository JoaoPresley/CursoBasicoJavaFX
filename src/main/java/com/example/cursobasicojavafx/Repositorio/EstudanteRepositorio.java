package com.example.cursobasicojavafx.Repositorio;

import com.example.cursobasicojavafx.Estudante;

import java.util.List;

public interface EstudanteRepositorio {

    public void porId();
    public List <Estudante> buscarTodos();
    public void inserir();

    void inserir(Estudante estudante);

    public void apagar();
}
