package Biblioteca;

import Titulo.Exemplar.Exemplar;

import java.util.LinkedList;

public class Prateleira {
    private int numero;
    private boolean ocupada;
    private LinkedList<Exemplar> exemplares;

    public Prateleira(int numero) {
        this.numero = numero;
        this.ocupada = false;
        this.exemplares = new LinkedList<>();
    }

    public void addExemplar(Exemplar exemplar) {
        if(exemplar == null) {
            return;
        }
        exemplares.add(exemplar);
        ocupada = exemplares.size() > 30;
    }

    public void removeExemplar(Exemplar exemplar) {
        if(exemplar == null) {
            return;
        }
        exemplares.remove(exemplar);
        ocupada = exemplares.size() > 30;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public int getNumero() {
        return numero;
    }
}
