/************************************************************************************
 *    Diogo Abegão Nº 2222184, João Parreira Nº 2221985, Pedro Barbeiro Nº2221986   *
 ************************************************************************************/

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

    public LinkedList<Subgenero> getSubgeneros() {
        return subgeneros;
    }

    public Subgenero getSubgenero(String nome) {
        for (Subgenero subgenero : subgeneros) {
            if (subgenero.getNome().equals(nome)) {
                return subgenero;
            }
        }
        return null;
    }
}
