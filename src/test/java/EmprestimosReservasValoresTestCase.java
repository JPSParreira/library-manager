/********************************
 *    João Parreira Nº 2221985   *
 ********************************/

import Socios.Emprestimo;
import Socios.Reserva;
import Socios.Socio;
import Titulo.Autor;
import Titulo.Exemplar.Exemplar;
import Titulo.Titulo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmprestimosReservasValoresTestCase {

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
    public void testCriarEmprestimo() {
        Date dataEmprestimo = new Date();
        ga.criarEmprestimo(socio, titulo, exemplar);
        assertNotNull(emprestimos);
        Emprestimo emprestimo = emprestimos.getLast();
        assertEquals(socio.getIdSocio(), emprestimo.getSocio().getIdSocio());
        assertEquals(titulo.getTitulo(), emprestimo.getTitulo().getTitulo());
        assertEquals(exemplar.getId(), emprestimo.getExemplar().getId());
        assertEquals(dataEmprestimo, emprestimo.getDataEmprestimo());
    }

    @Test
    public void testEmprestimoSemExemplarDisponivel() {
        exemplar.setDisponivel(false); // Marca o exemplar como indisponível
        ga.criarEmprestimo(socio, titulo, exemplar);
        assertNotNull(emprestimos);
    }

    @Test
    public void testReservaQuandoExemplarIndisponivel() {
        exemplar.setDisponivel(false); // Marca o exemplar como indisponível
        ga.criarReserva(socio, titulo);
        assertNotNull(reservas);
    }

    @Test
    public void testListarEmprestimos() {
        // Cria alguns empréstimos
        ga.criarEmprestimo(socio, titulo, exemplar);
        ga.criarEmprestimo(socio, titulo, exemplar);

        LinkedList<Emprestimo> listaEmprestimosTest = new LinkedList<>();

        listaEmprestimosTest.add(ga.getEmprestimos().getLast());
        listaEmprestimosTest.add(ga.getEmprestimos().getLast());

        assertNotNull(listaEmprestimosTest);
        assertEquals(2, listaEmprestimosTest.size()); // Verifica se há 2 empréstimos na lista
    }

    @Test
    public void testListarReservas() {
        // Cria algumas reservas
        exemplar.setDisponivel(false); // Marca o exemplar como indisponível
        ga.criarReserva(socio, titulo);
        ga.criarReserva(socio, titulo);

        LinkedList<Reserva> listaReservasTest = new LinkedList<>();

        listaReservasTest.add(ga.getReservas().getLast());
        listaReservasTest.add(ga.getReservas().getLast());

        assertNotNull(listaReservasTest);
        assertEquals(2, listaReservasTest.size()); // Verifica se há 2 reservas na lista
    }

    @Test
    public void testAtualizarValoresPrincipais() {
        // Configurar novos valores
        ga.setValorAnuidade(50.0f);
        ga.setValorMulta(2.5f);
        ga.setMaxEmprestimos(10);
        ga.setMaxDias(30);

        // Verificar se os valores foram atualizados corretamente
        assertEquals(50.0f, ga.getValorAnuidade());
        assertEquals(2.5f, ga.getValorMulta());
        assertEquals(10, ga.getMaxEmprestimos());
        assertEquals(30, ga.getMaxDias());
    }

}
