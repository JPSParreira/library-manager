/************************************************************************************
 *    Diogo Abegão Nº 2222184, João Parreira Nº 2221985, Pedro Barbeiro Nº2221986   *
 ************************************************************************************/

package Titulo.Exemplar;

import Biblioteca.Estante;
import Biblioteca.Prateleira;
import Titulo.Titulo;

public class Exemplar {
    private long ISBN;
    private int ano;
    private String edicao;
    private Titulo titulo;
    private Editora editora;
    private Distribuidor distribuidor;
    private String id;
    private Estante estante;
    private Prateleira prateleira;
    private boolean isDisponivel;

    public Exemplar(long ISBN, int ano, String edicao, Titulo titulo, Editora editora, Distribuidor distribuidor) {
        this.ISBN = ISBN;
        this.ano = ano;
        this.edicao = edicao;
        this.titulo = titulo;
        this.editora = editora;
        this.distribuidor = distribuidor;
        this.id = titulo.countExemplares() + "#" + ISBN;
        this.isDisponivel = true;
        this.prateleira = null;
        this.estante = null;
    }

    public String getId() {
        return id;
    }

    public long getISBN() {
        return ISBN;
    }

    public int getAno() {
        return ano;
    }

    public String getEdicao() {
        return edicao;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public Editora getEditora() {
        return editora;
    }

    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setEstante(Estante estanteLivre) {
        this.estante = estanteLivre;
    }

    public void setPrateleira(Prateleira prateleiraLivre) {
        this.prateleira = prateleiraLivre;
    }

    public Estante getEstante() {
        return estante;
    }

    public Prateleira getPrateleira() {
        return prateleira;
    }

    public void setDisponivel(boolean disponivel) {
        isDisponivel = disponivel;
    }

    public boolean isDisponivel() {
        return isDisponivel;
    }
}
