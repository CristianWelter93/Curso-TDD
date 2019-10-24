package leilao;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

    @Test
    public void deveReceberUmLance(){
        Leilao leilao = new Leilao("Macbook Pro 15");
        assertEquals(0, leilao.getLances().size());

        leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));

        assertEquals(1, leilao.getLances().size());
        assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.000001);
    }

    @Test
    public void deveReceberVariosLances(){
        Leilao leilao = new Leilao("Macbook Pro 15");
        assertEquals(0, leilao.getLances().size());

        leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
        leilao.propoe(new Lance(new Usuario("Steve Wozniak"), 3000));

        assertEquals(2, leilao.getLances().size());
        assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.000001);
        assertEquals(3000.0, leilao.getLances().get(1).getValor(), 0.000001);
    }

    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario(){
        Leilao leilao = new Leilao("Macbook Pro 15");
        Usuario steveJobs= new Usuario("Steve Jobs");

        leilao.propoe(new Lance(steveJobs, 2000));
        leilao.propoe(new Lance(steveJobs, 2500));

        assertEquals(1, leilao.getLances().size());
        assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.000001);
    }

    @Test
    public void naoDeveAceitarMaisQueCincoLancesDoMesmoUsuario(){
        Leilao leilao = new Leilao("Macbook Pro 15");

        Usuario steveJobs= new Usuario("Steve Jobs");
        Usuario bill= new Usuario("Bill");

        leilao.propoe(new Lance(steveJobs, 2000));
        leilao.propoe(new Lance(bill, 2500));

        leilao.propoe(new Lance(steveJobs, 3000));
        leilao.propoe(new Lance(bill, 2700));

        leilao.propoe(new Lance(steveJobs, 8000));
        leilao.propoe(new Lance(bill, 8230));

        leilao.propoe(new Lance(steveJobs, 14000));
        leilao.propoe(new Lance(bill, 14001));

        leilao.propoe(new Lance(steveJobs, 2000));
        leilao.propoe(new Lance(bill, 11000));

        leilao.propoe(new Lance(steveJobs, 20000));


        assertEquals(10, leilao.getLances().size());
        assertEquals(11000.0, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.000001);
    }

    @Test
    public void DeveDobrarUltimoLanceUsuario(){
        Leilao leilao = new Leilao("Macbook Pro 15");

        Usuario steveJobs= new Usuario("Steve Jobs");
        Usuario bill= new Usuario("Bill");
        Usuario carlos= new Usuario("Carlos");

        leilao.propoe(new Lance(carlos, 30));
        leilao.propoe(new Lance(steveJobs, 50));
        leilao.propoe(new Lance(carlos, 200));
        leilao.propoe(new Lance(bill, 250));
        leilao.propoe(new Lance(steveJobs, 300));
        leilao.propoe(new Lance(carlos, 600));
        leilao.propoe(new Lance(bill, 700));
        leilao.propoe(new Lance(bill, 800));

        leilao.dobralance(carlos);

        assertEquals(8, leilao.getLances().size());
        assertEquals(30.0, leilao.getLances().get(0).getValor(), 0.000001);
        assertEquals(50.0, leilao.getLances().get(1).getValor(), 0.000001);
        assertEquals(200.0, leilao.getLances().get(2).getValor(), 0.000001);
        assertEquals(250.0, leilao.getLances().get(3).getValor(), 0.000001);
        assertEquals(300.0, leilao.getLances().get(4).getValor(), 0.000001);
        assertEquals(600.0, leilao.getLances().get(5).getValor(), 0.000001);
        assertEquals(700.0, leilao.getLances().get(6).getValor(), 0.000001);
        assertEquals(1200.0, leilao.getLances().get(7).getValor(), 0.000001);


    }

}