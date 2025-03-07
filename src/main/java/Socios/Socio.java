package Socios; /************************************************************************************
 *    Diogo Abegão Nº 2222184, João Parreira Nº 2221985, Pedro Barbeiro Nº2221986   *
 ************************************************************************************/

import java.util.Date;

public class Socio {
    private static int socioIdCounter = 0;
    private int idSocio;
    private String nome;
    private String morada;
    private String email;
    private long nif;
    private long telemovel;
    private Date dataInscricao;
    private int numEmprestimosAtivos;
    private float multasEmDivida;
    private float anuidadesEmDivida;

    public Socio(String nome, String morada, String email, long nif, long telemovel) {
        socioIdCounter++;
        this.idSocio = socioIdCounter;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.nif = nif;
        this.telemovel = telemovel;
        this.dataInscricao = new Date();
        this.numEmprestimosAtivos = 0;
        this.multasEmDivida = 0.0f;
        this.anuidadesEmDivida = 0.0f;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public String getEmail() {
        return email;
    }

    public long getNif() {
        return nif;
    }

    public long getTelemovel() {
        return telemovel;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public int getNumEmprestimosAtivos() {
        return numEmprestimosAtivos;
    }

    public float getMultasEmDivida() {
        return multasEmDivida;
    }

    public float getAnuidadesEmDivida() {
        return anuidadesEmDivida;
    }

    public void incrementaNumEmprestimosAtivos() {
        this.numEmprestimosAtivos++;
    }
    public void decrementaNumEmprestimosAtivos() {
        this.numEmprestimosAtivos--;
    }

    public void setMultasEmDivida(float multasEmDivida) {
        this.multasEmDivida = multasEmDivida;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNif(long nif) {
        this.nif = nif;
    }

    public void setTelemovel(long telemovel) {
        this.telemovel = telemovel;
    }

    public void setAnuidadesEmDivida(float anuidadesEmDivida) {
        this.anuidadesEmDivida = anuidadesEmDivida;
    }

    public boolean isEmDivida() {
        return (this.multasEmDivida + this.anuidadesEmDivida == 0);
    }

    public String toString() {
        return this.nome;
    }
}

