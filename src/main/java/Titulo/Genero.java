package Titulo;

import java.util.LinkedList;

public class Genero {

    private String nome;
    private LinkedList<Subgenero> subgeneros;

    public Genero(String nome) {
        this.nome = nome;
        subgeneros = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addSubgenero(Subgenero subgenero) {
        if (subgenero == null) {
            return;
        }

        if (subgeneros.contains(subgenero)) {
            return;
        }

        subgeneros.add(subgenero);
    }
}
