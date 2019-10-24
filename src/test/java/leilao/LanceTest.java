package leilao;

import leilao.builder.CriadorDeLeilao;
import org.junit.Test;

import static leilao.LeilaoMatcher.temUmLance;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LanceTest {

    @Test(expected = RuntimeException.class)
    public  void exibeErroSeLanceMenorQueZero(){
        double valor=-100;
        Lance lance = new Lance(new Usuario("joao"),valor);
    }

    @Test(expected = RuntimeException.class)
    public  void exibeErroSeLanceIgualZero(){
        Lance lance = new Lance(new Usuario("joao"),0.0);
    }

    @Test
    public  void testePassaSeMaiorQueZero(){
        Lance lance = new Lance(new Usuario("joao"),10.0);

        assertThat(lance.getValor(), equalTo(10.0));
    }

    @Test
    public void deveReceberUmLance() {
        Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15").constroi();
        assertEquals(0, leilao.getLances().size());

        Lance lance = new Lance(new Usuario("Steve Jobs"), 2000);
        leilao.propoe(lance);

        assertThat(leilao.getLances().size(), equalTo(1));
        assertThat(leilao, temUmLance(lance));
    }

}
