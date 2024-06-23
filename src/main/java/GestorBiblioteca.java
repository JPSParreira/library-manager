import java.util.LinkedList;

public class GestorBiblioteca {
    private int maximoDiasEmprestimo;
    private float valorMultaPorDia;
    private int maximoLivrosEmprestados;
    private float valorAnuidade;
    private LinkedList<Estante> estantes;
    private LinkedList<Exemplar> exemplares;
    private LinkedList<Socio> socios;
    private LinkedList<Emprestimo> emprestimos;
    private LinkedList<Reserva> reservas;

    public static final GestorBiblioteca instance = new GestorBiblioteca();

    private GestorBiblioteca() {
        maximoDiasEmprestimo = 15;
        valorMultaPorDia = 1f;
        maximoLivrosEmprestados = 3;
        valorAnuidade = 20.0f;
    }

    public int getMaxDias() {
        return maximoDiasEmprestimo;
    }

    public void setMaxDias(int maximoDiasEmprestimo) {
        this.maximoDiasEmprestimo = maximoDiasEmprestimo;
    }

    public float getValorMulta() {
        return valorMultaPorDia;
    }

    public void setValorMulta(float valorMultaPorDia) {
        this.valorMultaPorDia = valorMultaPorDia;
    }

    public int getMaxEmprestimos() {
        return maximoLivrosEmprestados;
    }

    public void setMaxEmprestimos(int maximoLivrosEmprestados) {
        this.maximoLivrosEmprestados = maximoLivrosEmprestados;
    }

    public float getValorAnuidade() {
        return valorAnuidade;
    }

    public void setValorAnuidade(float valorAnuidade) {
        this.valorAnuidade = valorAnuidade;
    }
}
