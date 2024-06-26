/********************************
 *  Pedro Barbeiro Nº 2221986   *
 ********************************/

import static org.junit.jupiter.api.Assertions.*;

import Titulo.Exemplar.Editora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EditoraTestCase {

    private Editora editora;

    @BeforeEach
    public void setUp() {
        editora = new Editora("Editora Original");
    }

    @Test
    public void testConstructor() {
        assertEquals("Editora Original", editora.getNome());
    }

    @Test
    public void testGetNome() {
        assertEquals("Editora Original", editora.getNome());
    }

    @Test
    public void testSetNome() {
        editora.setNome("Nova Editora");
        assertEquals("Nova Editora", editora.getNome());
    }
}
