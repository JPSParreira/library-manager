import java.util.Date;

public class Socio {
    private static int idCounter = 0;
    private int idSocio;
    private String nome;
    private String morada;
    private String email;
    private long nif;
    private long telemovel;
    private int numEmprestimosAtivos;
    private boolean ativo;
    private float multasEmDivida;
    private float anuidadesEmDivida;
    private Date dataInscricao;

    public Socio(String nome, String morada, String email, long nif, long telemovel) {
        this.idSocio = idCounter;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.nif = nif;
        this.telemovel = telemovel;
        this.numEmprestimosAtivos = 0;
        this.ativo = false;
        this.multasEmDivida = 0.0f;
        this.anuidadesEmDivida = GestorBiblioteca.instance.getValorAnuidade();
        this.dataInscricao = new Date();
        idCounter++;
    }
}
