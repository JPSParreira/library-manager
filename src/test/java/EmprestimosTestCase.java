import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import Titulo.Exemplar.Exemplar;
import Titulo.Titulo;

public class EmprestimosTestCase {

    private GestorBiblioteca gestorBiblioteca;
    private Socio socio;
    private Titulo titulo;
    private Exemplar exemplar;
    private Emprestimo emprestimo;

    @BeforeEach
    public void setUp() {
        gestorBiblioteca = GestorBiblioteca.instance;
        socio = new Socio("João", "Rua A", "joao@example.com", 123456789, 987654321);
        titulo = new Titulo("Livro de Teste", "Autor Teste", "1234567890123");
        exemplar = new Exemplar(titulo);
        gestorBiblioteca.adicionarSocio(socio);
        gestorBiblioteca.adicionarTitulo(titulo);
        gestorBiblioteca.adicionarExemplar(exemplar);
    }

    @Test
    public void testCriarEmprestimo() {
        Date dataEmprestimo = new Date();
        emprestimo = gestorBiblioteca.criarEmprestimo(socio.getIdSocio(), titulo, exemplar.getId());
        assertNotNull(emprestimo);
        assertEquals(socio.getIdSocio(), emprestimo.getIdSocio());
        assertEquals(titulo.getId(), emprestimo.getIdTitulo());
        assertEquals(exemplar.getId(), emprestimo.getIdExemplar());
        assertEquals(dataEmprestimo, emprestimo.getDataEmprestimo());
    }

    @Test
    public void testEmprestimoSemExemplarDisponivel() {
        exemplar.setDisponivel(false); // Marca o exemplar como indisponível
        emprestimo = gestorBiblioteca.criarEmprestimo(socio, titulo, exemplar);
        assertNull(emprestimo);
    }

    @Test
    public void testReservaQuandoExemplarIndisponivel() {
        exemplar.setDisponivel(false); // Marca o exemplar como indisponível
        boolean reservaCriada = gestorBiblioteca.criarReserva(socio.getIdSocio(), titulo.getId());
        assertTrue(reservaCriada);
    }
}

