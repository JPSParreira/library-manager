import Titulo.Titulo;

import java.util.Date;

public class Reserva {
    private static int reservaIdCounter = 0;
    private int idReserva;
    private int idSocio;
    private Titulo titulo;
    private Date dataReserva;
    private boolean ativa;

    public Reserva(int idSocio, Titulo titulo) {
        reservaIdCounter++;
        this.idReserva = reservaIdCounter;
        this.idSocio = idSocio;
        this.titulo = titulo;
        this.dataReserva = new Date();
        this.ativa = true;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public int getIdSocio() {
        return idSocio;
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
