package Socios; /************************************************************************************
 *    Diogo Abegão Nº 2222184, João Parreira Nº 2221985, Pedro Barbeiro Nº2221986   *
 ************************************************************************************/

import Titulo.Titulo;

import java.util.Date;

public class Reserva {
    private static int reservaIdCounter = 0;
    private int idReserva;
    private Socio socio;
    private Titulo titulo;
    private Date dataReserva;
    private boolean ativa;

    public Reserva(Socio socio, Titulo titulo) {
        reservaIdCounter++;
        this.idReserva = reservaIdCounter;
        this.socio = socio;
        this.titulo = titulo;
        this.dataReserva = new Date();
        this.ativa = true;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Socio getSocio() {
        return socio;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}
