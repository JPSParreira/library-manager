package Titulo;

import Titulo.Exemplar.Exemplar;

import java.util.LinkedList;

public class Titulo {

    private String nome;
    private Autor autor;
    private Genero genero;
    private LinkedList<Exemplar> exemplares;

    public Titulo(String nome, Autor autor, Genero genero) {
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        exemplares = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LinkedList<Exemplar> getExemplares() {
        return exemplares;
    }

    public void addExemplar(Exemplar exemplar) {
        if (exemplar == null) {
            return;
        }

        if (exemplares.contains(exemplar)) {
            return;
        }

        exemplares.add(exemplar);
    }

}
