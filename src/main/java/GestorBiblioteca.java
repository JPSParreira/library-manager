import java.util.LinkedList;

public class GestorBiblioteca {
    private int maximoDiasEmprestimo = 7;
    private float valorMultaPorDia = 0.5f;
    private int maximoLivrosEmprestados = 5;
    private float valorAnuidade = 10.0f;
    private LinkedList<Estante> estantes;
    private LinkedList<Exemplar> exemplares;
    private LinkedList<Socio> socios;
    private LinkedList<Emprestimo> emprestimos;
    private LinkedList<Reserva> reservas;

    public static final GestorBiblioteca instance = new GestorBiblioteca();

    private GestorBiblioteca() {
        // load data from disk
    }

}
