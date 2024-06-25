import Titulo.Titulo;

import java.util.Date;

public class Emprestimo {
    private static int emprestimoIdCounter = 0;
    private int idEmprestimo;
    private int idSocio;
    private Titulo titulo;
    private String idExemplar;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean devolvido;
    private float multa;

    public Emprestimo(int idSocio,Titulo titulo, String idExemplar) {
        emprestimoIdCounter++;
        this.idEmprestimo = emprestimoIdCounter;
        this.idSocio = idSocio;
        this.titulo = titulo;
        this.idExemplar = idExemplar;
        this.dataEmprestimo = new Date();
        this.dataDevolucao = null;
        this.devolvido = false;
        this.multa = 0.0f;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public String getIdExemplar() {
        return idExemplar;
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
