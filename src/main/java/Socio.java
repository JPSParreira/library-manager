import java.util.Date;

public class Socio {
    private int idSocio;
    private String nome;
    private String morada;
    private String email;
    private long nif;
    private long telemovel;
    private int numEmprestimosAtivos;
    private float multasEmDivida;
    private float anuidadesEmDivida;
    private Date dataInscricao;

    public Socio(String nome, String morada, String email, long nif, long telemovel) {
        GestorBiblioteca.instance.incrementSocioidCounter();
        this.idSocio = GestorBiblioteca.instance.getSocioidCounter();
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.nif = nif;
        this.telemovel = telemovel;
        this.numEmprestimosAtivos = 0;
        this.multasEmDivida = 0.0f;
        this.anuidadesEmDivida = GestorBiblioteca.instance.getValorAnuidade();
        this.dataInscricao = new Date();
    }
}
