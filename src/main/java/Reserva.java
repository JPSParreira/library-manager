import java.util.Date;

public class Reserva {
    private static int reservaIdCounter = 0;
    private int idReserva;
    private int idSocio;
    private String idExemplar;
    private Date dataReserva;
    private boolean ativa;

    public Reserva(int idSocio, String idExemplar) {
        reservaIdCounter++;
        this.idReserva = reservaIdCounter;
        this.idSocio = idSocio;
        this.idExemplar = idExemplar;
        this.dataReserva = new Date();
        this.ativa = true;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public String getIdExemplar() {
        return idExemplar;
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
