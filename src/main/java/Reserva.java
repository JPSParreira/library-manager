import java.util.Date;

public class Reserva {
    private static int reservaIdCounter = 0;
    private int idReserva;
    private int idSocio;
    private long ISBN;
    private Date dataReserva;
    private boolean ativa;

    public Reserva(int idSocio, long ISBN) {
        reservaIdCounter++;
        this.idReserva = reservaIdCounter;
        this.idSocio = idSocio;
        this.ISBN = ISBN;
        this.dataReserva = new Date();
        this.ativa = true;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public long getISBN() {
        return ISBN;
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
