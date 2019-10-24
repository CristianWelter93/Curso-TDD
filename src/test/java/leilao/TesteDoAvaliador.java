package leilao;

import leilao.Avaliador;
import leilao.Lance;
import leilao.Leilao;
import leilao.Usuario;
import leilao.builder.CriadorDeLeilao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TesteDoAvaliador {

    private Avaliador leiloeiro;
    private Usuario joao;
    private Usuario jose;
    private Usuario maria;
    private Usuario marcia;
    private Usuario marta ;
    private Usuario junior;

    @Before
    public void criaAvaliador(){
        leiloeiro = new Avaliador();
        this.joao= new Usuario("João");
        this.jose= new Usuario("Jose");
        this.maria= new Usuario("Maria");
        this.marcia= new Usuario("Marcia");
        this.marta= new Usuario("Marta");
        this.junior= new Usuario("Junior");
    }

    @Test
    public void deveEntenderLancesEmOrdemCrescente(){
        Leilao leilao = new CriadorDeLeilao().para("Play 3 novo")
                .lance(joao, 250)
                .lance(jose, 300)
                .lance(maria, 400)
                .constroi();

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
        Leilao leilao = new CriadorDeLeilao().para("Play 3 novo")
                .lance(joao, 1000)
                .constroi();

        leiloeiro.avalia(leilao);

        double maiorEsperado = 1000;
        double menorEsperado = 1000;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEcontrarOsTresMaioresLances(){
        Leilao leilao = new CriadorDeLeilao().para("Play 3 novo")
                .lance(joao, 100)
                .lance(jose, 200)
                .lance(joao, 300)
                .lance(maria, 400)
                .lance(jose, 350)
                .constroi();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3,maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(350, maiores.get(1).getValor(), 0.00001);
        assertEquals(300, maiores.get(2).getValor(), 0.00001);
    }

    @Test
    public void deveEcontrarOsMaioresMesmoComMenosQueTresLances(){

        Leilao leilao = new CriadorDeLeilao().para("Play 3 novo")
             .lance(joao, 100)
            .lance(jose, 200)
            .constroi();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(2,maiores.size());
        assertEquals(200, maiores.get(0).getValor(), 0.00001);
        assertEquals(100, maiores.get(1).getValor(), 0.00001);
    }

    @Test
    public void deveDevolverListaVaziaCasoNaoHajaLances(){
        Leilao leilao = new Leilao("Play 3 novo");

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(0,maiores.size());
    }

    @Test
    public void deveEntenderLancesEmOrdemRandomica(){
        Leilao leilao = new CriadorDeLeilao().para("Play 3 novo")
                .lance(joao, 200)
                .lance(jose, 450)
                .lance(maria, 120)
                .lance(marta, 700)
                .lance(marcia, 630)
                .lance(junior, 230)
                .constroi();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 700;
        double menorEsperado = 120;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEntenderLancesEmOrdemDecrescente(){
        Leilao leilao = new CriadorDeLeilao().para("Play 3 novo")
                .lance(joao, 400)
                .lance(jose, 300)
                .lance(joao, 200)
                .lance(maria, 100)
                .constroi();

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3,maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
        assertEquals(100, leiloeiro.getMenorLance(), 0.00001);
    }
}
