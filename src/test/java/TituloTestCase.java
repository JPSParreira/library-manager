/********************************
 *  Pedro Barbeiro Nº 2221986   *
 ********************************/

import Titulo.*;
import Titulo.Exemplar.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TituloTestCase {

    private Genero genero;
    private Subgenero subgenero;
    private Autor autor;
    private Titulo titulo;
    private Exemplar exemplarDisponivel;
    private Exemplar exemplarIndisponivel;

    @BeforeEach
    public void setUp() {
        genero = new Genero("GeneroTeste");
        subgenero = new Subgenero("SubgeneroTeste");
        autor = new Autor("Pedro Barbeiro");
        titulo = new Titulo("Livro",autor,genero,subgenero);
        exemplarDisponivel = new Exemplar(1234567891234L, 2000, "1ª Edição", titulo, new Editora("Editora"), new Distribuidor("Distribuidor"));
        exemplarIndisponivel = new Exemplar(1234567891234L, 2000, "1ª Edição", titulo, new Editora("Editora"), new Distribuidor("Distribuidor"));

        exemplarDisponivel.setDisponivel(true);
        exemplarIndisponivel.setDisponivel(false);
    }

    @Test
    public void testCreateTitle() {
        assertEquals("Livro", titulo.getTitulo());
        assertEquals("Pedro Barbeiro", titulo.getAutor().getNome());
        assertEquals("GeneroTeste", titulo.getGenero().getNome());
        assertEquals("SubgeneroTeste", titulo.getSubGenero().getNome());
    }

    @Test
    public void testAddExemplar() {
        assertEquals(0, titulo.countExemplares());
        titulo.addExemplar(exemplarDisponivel);
        assertEquals(1, titulo.countExemplares());

        //caso introduza o exemplar novamente o resultado deverá ser o mesmo
        titulo.addExemplar(exemplarDisponivel);
        assertEquals(1, titulo.countExemplares());
    }

    @Test
    public void testIsDisponivel() {
        //sem exemplares, o titulo não está disponível
        assertFalse(titulo.isDisponivel());
        //adicionei um exemplar disponível, o titulo está disponível
        titulo.addExemplar(exemplarDisponivel);
        assertTrue(titulo.isDisponivel());
        //o exemplar disponível foi emprestado, o titulo não está disponível
        exemplarDisponivel.setDisponivel(false);
        assertFalse(titulo.isDisponivel());
    }

    @Test
    public void testGetExemplarDisponivel() {
        //sem exemplares, o titulo não tem exemplar disponível
        assertNull(titulo.getExemplarDisponivel());
        //adicionei um exemplar disponível, o titulo tem um exemplar disponível
        titulo.addExemplar(exemplarDisponivel);
        assertNotNull(titulo.getExemplarDisponivel());
        //o exemplar disponível foi emprestado, o titulo não tem exemplar disponível
        exemplarDisponivel.setDisponivel(false);
        assertNull(titulo.getExemplarDisponivel());
    }

}
