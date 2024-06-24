import java.util.Date;

public class Emprestimo {
    private int id;
    private int idSocio;
    private int idExemplar;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean devolvido;
    private float multa;

    public Emprestimo(int id, int idSocio, int idExemplar) {
        GestorBiblioteca.instance.incrementEmprestimoIdCounter();
        this.id = GestorBiblioteca.instance.getEmprestimoIdCounter();
        this.idSocio = idSocio;
        this.idExemplar = idExemplar;
        this.dataEmprestimo = new Date();
        this.dataDevolucao = null;
        this.devolvido = false;
        this.multa = 0.0f;
    }
}
