/********************************
 *  Pedro Barbeiro Nº 2221986   *
 ********************************/

import static org.junit.jupiter.api.Assertions.*;

import Titulo.Exemplar.Distribuidor;
import Titulo.Exemplar.Editora;
import Titulo.Exemplar.Exemplar;
import Titulo.Autor;
import Titulo.Genero;
import Titulo.Subgenero;
import Titulo.Titulo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExemplarTestCase {

    private Exemplar exemplar;
    private Titulo titulo;
    private Editora editora;
    private Distribuidor distribuidor;

    @BeforeEach
    public void setUp() {
        Autor autor = new Autor("Pedro Barbeiro");
        Genero genero = new Genero("GeneroTESTE");
        Subgenero subgenero = new Subgenero("SubgeneroTESTE");
        titulo = new Titulo("LivroTESTE", autor, genero, subgenero);
        editora = new Editora("EditoraTESTE");
        distribuidor = new Distribuidor("DistribuidorTESTE");
        exemplar = new Exemplar(1234567891234L, 2021, "1ª Edição", titulo, editora, distribuidor);
    }

    @Test
    public void testConstructorAndInitialState() {
        assertEquals(1234567891234L, exemplar.getISBN());
        assertEquals(2021, exemplar.getAno());
        assertEquals("1ª Edição", exemplar.getEdicao());
        assertEquals(titulo, exemplar.getTitulo());
        assertEquals(editora, exemplar.getEditora());
        assertEquals(distribuidor, exemplar.getDistribuidor());
        assertTrue(exemplar.isDisponivel());
        assertNull(exemplar.getEstante());
        assertNull(exemplar.getPrateleira());
    }

    @Test
    public void testGetters() {
        assertEquals(1234567891234L, exemplar.getISBN());
        assertEquals(2021, exemplar.getAno());
        assertEquals("1ª Edição", exemplar.getEdicao());
        assertEquals(titulo, exemplar.getTitulo());
        assertEquals(editora, exemplar.getEditora());
        assertEquals(distribuidor, exemplar.getDistribuidor());
    }

    @Test
    public void testIdGeneration() {
        String expectedId = "0#1234567891234";
        assertEquals(expectedId, exemplar.getId());
    }
}
