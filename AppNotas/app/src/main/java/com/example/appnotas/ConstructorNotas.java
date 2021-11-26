package com.example.appnotas;

import java.io.Serializable;

public class ConstructorNotas implements Serializable {
    private String titulo;
    private String nota;

    public ConstructorNotas(){}

    public ConstructorNotas(String titulo,String nota){
        this.titulo = titulo;
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
