package matematica;

import org.junit.Test;
import static org.junit.Assert.*;
public class AnoBissextoTest {

    @Test
    public void verSeEstaMostrandoAnosBissextos(){
        int ano1= 0;
        int ano2= 160;
        int ano3= 1854;
        int ano4= 400;
        int ano5= 800;
        int ano6 = 1993;
        int ano7= 2000;

        assertEquals(true,new AnoBissexto().ehBissexto(ano1));
        assertEquals(true,new AnoBissexto().ehBissexto(ano2));
        assertEquals(false,new AnoBissexto().ehBissexto(ano3));
        assertEquals(true,new AnoBissexto().ehBissexto(ano4));
        assertEquals(true,new AnoBissexto().ehBissexto(ano5));
        assertEquals(false,new AnoBissexto().ehBissexto(ano6));
        assertEquals(true,new AnoBissexto().ehBissexto(ano7));

    }
}
