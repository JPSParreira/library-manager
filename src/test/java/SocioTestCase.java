/********************************
 *    Diogo Abegão Nº 2222184   *
 ********************************/

import Socios.Emprestimo;
import Socios.Reserva;
import Socios.Socio;
import Titulo.Autor;
import Titulo.Exemplar.Exemplar;
import Titulo.Titulo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SocioTestCase {

    private GestorBiblioteca ga;
    private Socio socio;
    private Autor autor;
    private Titulo titulo;
    private Exemplar exemplar;
    private LinkedList<Emprestimo> emprestimos = new LinkedList<>();
    private LinkedList<Reserva> reservas = new LinkedList<>();

    @BeforeEach
    public void setUp() {
        ga = GestorBiblioteca.instance;
        socio = new Socio("João", "Rua A", "joao@example.com", 123456789, 987654321);
        autor = new Autor("J.K. Rowling");
        titulo = new Titulo("Harry Potter e a Pedra Filosofal", autor, ga.getGenero("Fantasia"), ga.getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        exemplar = new Exemplar(1234567890121L, 2000, "1ª Edição", titulo, ga.getEditora("Editora 3"), ga.getDistribuidor("Distribuidor 10"));
        emprestimos = ga.getEmprestimos();
        reservas = ga.getReservas();
    }

    @Test
    public void testConstrutor() {
        assertEquals("João", socio.getNome());
        assertEquals("Rua A", socio.getMorada());
        assertEquals("joao@example.com", socio.getEmail());
        assertEquals(987654321, socio.getTelemovel());
        assertEquals(123456789, socio.getNif());
    }

    @Test
    public void testAtualizarDadosSocio() {
        socio.setNome("João Atualizado");
        socio.setMorada("Rua B");
        socio.setEmail("joaoatualizado@example.com");
        socio.setNif(987654321);
        socio.setTelemovel(123456789);

        assertEquals("João Atualizado", socio.getNome());
        assertEquals("Rua B", socio.getMorada());
        assertEquals("joaoatualizado@example.com", socio.getEmail());
        assertEquals(987654321, socio.getNif());
        assertEquals(123456789, socio.getTelemovel());
    }

    @Test
    public void testIncrementarEmprestimosAtivos() {
        int emprestimosAtivosAntes = socio.getNumEmprestimosAtivos();
        socio.incrementaNumEmprestimosAtivos();
        assertEquals(emprestimosAtivosAntes + 1, socio.getNumEmprestimosAtivos());
    }

    @Test
    public void testIncrementarMultasEmDivida() {
        float multasAntes = socio.getMultasEmDivida();
        socio.setMultasEmDivida(multasAntes + 5.0f);
        assertEquals(multasAntes + 5.0f, socio.getMultasEmDivida());
    }

    @Test
    public void testIncrementarAnuidadesEmDivida() {
        float anuidadesAntes = socio.getAnuidadesEmDivida();
        socio.setAnuidadesEmDivida(anuidadesAntes + 10.0f);
        assertEquals(anuidadesAntes + 10.0f, socio.getAnuidadesEmDivida());
    }
}
