/************************************************************************************
 *    Diogo Abegão Nº 2222184, João Parreira Nº 2221985, Pedro Barbeiro Nº2221986   *
 ************************************************************************************/

package Titulo;

import java.util.LinkedList;

public class Autor {
    private String nome;
    private LinkedList<Titulo> titulos;

    public Autor(String nome) {
        this.nome = nome;
        titulos = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addTitulo(Titulo titulo) {
        titulos.add(titulo);
    }

    public LinkedList<Titulo> getTitulos() {
        return titulos;
    }
}
