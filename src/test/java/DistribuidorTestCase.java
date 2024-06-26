import static org.junit.jupiter.api.Assertions.*;

import Titulo.Exemplar.Distribuidor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistribuidorTestCase {

    private Distribuidor distribuidor;

    @BeforeEach
    public void setUp() {
        distribuidor = new Distribuidor("DistribuidorTESTE");
    }

    @Test
    public void testConstructor() {
        assertEquals("DistribuidorTESTE", distribuidor.getNome());
    }

    @Test
    public void testGetNome() {
        assertEquals("DistribuidorTESTE", distribuidor.getNome());
    }

    @Test
    public void testSetNome() {
        distribuidor.setNome("DistribuidorTESTE2");
        assertEquals("DistribuidorTESTE2", distribuidor.getNome());
    }
}
