package leilao;

import leilao.Avaliador;
import leilao.Lance;
import leilao.Leilao;
import leilao.Usuario;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TesteDoAvaliador {
    @Test
    public void deveEntenderLancesEmOrdemCrescente(){
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("Jose");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Play 3 novo");

        leilao.propoe(new Lance(joao, 250));
        leilao.propoe(new Lance(jose, 300));
        leilao.propoe(new Lance(maria, 400));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 400;
        double menorEsperado = 250;
        double mediaEsperado =(double) (250+300+400)/3;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
        assertEquals(mediaEsperado, leiloeiro.getMediaDosLances(leilao), 0.00001);
    }

    @Test
    public void deveEntenderLeilaoComApenasUmLance(){
        Usuario joao = new Usuario("Joao");


        Leilao leilao = new Leilao("Play 3 novo");

        leilao.propoe(new Lance(joao, 1000));


        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 1000;
        double menorEsperado = 1000;


        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEcontrarOsTresMaioresLances(){
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("Jose");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Play 3 novo");

        leilao.propoe(new Lance(joao, 100));
        leilao.propoe(new Lance(jose, 200));
        leilao.propoe(new Lance(joao, 300));
        leilao.propoe(new Lance(maria, 400));
        leilao.propoe(new Lance(jose, 350));


        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3,maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(350, maiores.get(1).getValor(), 0.00001);
        assertEquals(300, maiores.get(2).getValor(), 0.00001);
    }

    @Test
    public void deveEcontrarOsMaioresMesmoComMenosQueTresLances(){
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("Jose");


        Leilao leilao = new Leilao("Play 3 novo");

        leilao.propoe(new Lance(joao, 100));
        leilao.propoe(new Lance(jose, 200));



        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(2,maiores.size());
        assertEquals(200, maiores.get(0).getValor(), 0.00001);
        assertEquals(100, maiores.get(1).getValor(), 0.00001);
    }

    @Test
    public void deveDevolverListaVaziaCasoNaoHajaLances(){
        Usuario joao = new Usuario("Joao");


        Leilao leilao = new Leilao("Play 3 novo");

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(0,maiores.size());
    }

    @Test
    public void deveEntenderLancesEmOrdemRandomica(){
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("Jose");
        Usuario maria = new Usuario("Maria");
        Usuario marcia = new Usuario("Marcia");
        Usuario marta = new Usuario("Marta");
        Usuario junior = new Usuario("Junior");


        Leilao leilao = new Leilao("Play 3 novo");

        leilao.propoe(new Lance(joao, 200));
        leilao.propoe(new Lance(jose, 450));
        leilao.propoe(new Lance(maria, 120));
        leilao.propoe(new Lance(marta, 700));
        leilao.propoe(new Lance(marcia, 630));
        leilao.propoe(new Lance(junior, 230));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 700;
        double menorEsperado = 120;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEntenderLancesEmOrdemDecrescente(){
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("Jose");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Play 3 novo");

        leilao.propoe(new Lance(joao, 400));
        leilao.propoe(new Lance(jose, 300));
        leilao.propoe(new Lance(joao, 200));
        leilao.propoe(new Lance(maria, 100));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3,maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
        assertEquals(100, leiloeiro.getMenorLance(), 0.00001);
    }
}
