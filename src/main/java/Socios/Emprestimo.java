package Socios; /************************************************************************************
 *    Diogo Abegão Nº 2222184, João Parreira Nº 2221985, Pedro Barbeiro Nº2221986   *
 ************************************************************************************/

import Titulo.Exemplar.Exemplar;
import Titulo.Titulo;

import java.util.Date;

public class Emprestimo {
    private static int emprestimoIdCounter = 0;
    private int idEmprestimo;
    private Socio socio;
    private Titulo titulo;
    private Exemplar exemplar;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean devolvido;
    private float multa;

    public Emprestimo(Socio socio, Titulo titulo, Exemplar exemplar) {
        emprestimoIdCounter++;
        this.idEmprestimo = emprestimoIdCounter;
        this.socio = socio;
        this.titulo = titulo;
        this.exemplar = exemplar;
        this.dataEmprestimo = new Date();
        this.dataDevolucao = null;
        this.devolvido = false;
        this.multa = 0.0f;
        titulo.addEmprestimo();
    }
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public Socio getSocio() {
        return socio;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public float getMulta() {
        return multa;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }
}
