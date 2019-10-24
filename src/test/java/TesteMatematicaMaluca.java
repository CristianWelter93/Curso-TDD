import matematica.MatematicaMaluca;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TesteMatematicaMaluca {

    @Test
    public void testaNumeroMaiorQueTrinta()
    {
        MatematicaMaluca matematica = new MatematicaMaluca();
        int numero=60;
        int esperado = numero*4;

        assertEquals(esperado,matematica.contaMaluca(numero), 0.000001);
    }

    @Test
    public void testaNumeroIgualATrinta()
    {
        MatematicaMaluca matematica = new MatematicaMaluca();
        int numero=30;
        int esperado = numero*3;

        assertEquals(esperado,matematica.contaMaluca(numero), 0.000001);
    }

    @Test
    public void testaNumeroMenorQueTrintaEMaiorQueDez()
    {
        MatematicaMaluca matematica = new MatematicaMaluca();
        int numero=20;
        int esperado = numero*3;

        assertEquals(esperado,matematica.contaMaluca(numero), 0.000001);
    }
    @Test
    public void testaNumeroIgualDez()
    {
        MatematicaMaluca matematica = new MatematicaMaluca();
        int numero=10;
        int esperado = numero*2;

        assertEquals(esperado,matematica.contaMaluca(numero), 0.000001);
    }

    @Test
    public void testaNumeroMenorQueDez()
    {
        MatematicaMaluca matematica = new MatematicaMaluca();
        int numero=9;
        int esperado = numero*2;

        assertEquals(esperado,matematica.contaMaluca(numero), 0.000001);
    }
}
