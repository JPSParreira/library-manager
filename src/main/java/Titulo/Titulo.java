/************************************************************************************
 *    Diogo Abegão Nº 2222184, João Parreira Nº 2221985, Pedro Barbeiro Nº2221986   *
 ************************************************************************************/

package Titulo;

import Titulo.Exemplar.Exemplar;

import java.util.LinkedList;

public class Titulo {

    private String titulo;
    private Autor autor;
    private Genero genero;
    private Subgenero subgenero;
    private LinkedList<Exemplar> exemplares;
    private int emprestimos;

    public Titulo(String nome, Autor autor, Genero genero, Subgenero subgenero) {
        this.titulo = nome;
        this.autor = autor;
        this.genero = genero;
        this.subgenero = subgenero;
        exemplares = new LinkedList<>();
        emprestimos = 0;
    }

    public void setEmprestimos(int emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void addEmprestimo() {
        emprestimos++;
    }

    public int getEmprestimos() {
        return emprestimos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public int countExemplares() {
        return exemplares.size();
    }

    public boolean isDisponivel() {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel()) {
                return true;
            }
        }
        return false;
    }

    public boolean isDisponivel(Exemplar exemplar) {
        return exemplar.isDisponivel();
    }

    public Exemplar getExemplarDisponivel() {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel()) {
                return exemplar;
            }
        }
        return null;
    }

    public Subgenero getSubGenero() {
        return subgenero;
    }

}
