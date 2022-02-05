package javagame.logisticadecombate;

import javagame.bonecos.*;
import org.junit.Assert;
import org.junit.Test;

public class CampoTest {

    @Test
    public void exibir() {

        Campo campo = new Campo();

        Lineuzinho lineuzinho = new Lineuzinho();
        Padinho padinho = new Padinho();

        campo.inserir(lineuzinho,3);
        campo.inserir(padinho,2);

        Assert.assertEquals("| | |P|Z| | | | | | |", campo.exibir());

    }

    @Test
    public void padinhoMorreAoLevarDanoFatal(){

        Campo campo = new Campo();

        Marquinhos marquinhos = new Marquinhos();
        Padinho padinho = new Padinho();

        campo.inserir(marquinhos,2);
        campo.inserir(padinho,4);

        padinho.setConstituicao(1);

        marquinhos.getClasse().buscaVitima(marquinhos, campo, marquinhos.getPosicaoAtual());

        Assert.assertEquals("| | | | |M| | | | | |", campo.exibir());

    }

    @Test
    public void marquinhosMorreAoLevarDanoFatal(){

        Campo campo = new Campo();

        Marquinhos marquinhos = new Marquinhos();
        Padinho padinho = new Padinho();

        campo.inserir(marquinhos,2);
        campo.inserir(padinho,4);

        marquinhos.setConstituicao(1);

        marquinhos.getClasse().buscaVitima(padinho, campo, padinho.getPosicaoAtual());

        Assert.assertEquals("| | |P| | | | | | | |", campo.exibir());

    }

    @Test
    public void marquinhosPriorizaBonecoMaisDistante(){

        Campo campo = new Campo();

        Marquinhos marquinhos = new Marquinhos();
        Padinho padinho = new Padinho();
        Rodriguinho rodriguinho = new Rodriguinho();

        campo.inserir(marquinhos,2);
        campo.inserir(padinho,4);
        campo.inserir(rodriguinho, 3);

        padinho.setConstituicao(1);

        marquinhos.getClasse().buscaVitima(marquinhos, campo, marquinhos.getPosicaoAtual());

        Assert.assertEquals("| | |M|R| | | | | | |", campo.exibir());

    }

    @Test
    public void marquinhosPriorizaBonecoMaisDistanteENaoSeMovimentaPoisNaoMata(){

        Campo campo = new Campo();

        Marquinhos marquinhos = new Marquinhos();
        Claudinho claudinho = new Claudinho();
        Rodriguinho rodriguinho = new Rodriguinho();

        campo.inserir(marquinhos,2);
        campo.inserir(claudinho,4);
        campo.inserir(rodriguinho, 3);

        marquinhos.getClasse().buscaVitima(marquinhos, campo, marquinhos.getPosicaoAtual());

        Assert.assertEquals("| | |M|R|A| | | | | |", campo.exibir());

    }

    @Test
    public void padinhoPriorizaBonecoMaisDistanteENaoSeMovimentaPoisNaoMata(){

        Campo campo = new Campo();

        Marquinhos marquinhos = new Marquinhos();
        Padinho padinho = new Padinho();
        Lineuzinho lineuzinho = new Lineuzinho();

        campo.inserir(marquinhos,2);
        campo.inserir(padinho,4);
        campo.inserir(lineuzinho, 3);

        marquinhos.getClasse().buscaVitima(padinho, campo, padinho.getPosicaoAtual());

        Assert.assertEquals("| | |M|Z|P| | | | | |", campo.exibir());

    }

    @Test
    public void claudinhoAtacaESeMovimentaAoMatar(){

        Campo campo = new Campo();

        Claudinho claudinho = new Claudinho();
        Padinho padinho = new Padinho();

        campo.inserir(claudinho, 2);
        campo.inserir(padinho,3);
        padinho.setConstituicao(18);

        claudinho.getClasse().buscaVitima(claudinho, campo, claudinho.getPosicaoAtual());
        Assert.assertEquals("| | | |A| | | | | | |", campo.exibir());


    }

    @Test
    public void claudinhoAtacaENaoSeMovimentaAoNaoMatar(){

        Campo campo = new Campo();

        Claudinho claudinho = new Claudinho();
        Padinho padinho = new Padinho();

        campo.inserir(claudinho, 2);
        campo.inserir(padinho,3);


        claudinho.getClasse().buscaVitima(claudinho, campo, claudinho.getPosicaoAtual());
        Assert.assertEquals("| | |A|P| | | | | | |", campo.exibir());


    }

    @Test
    public void rodriguinhoAtacaENaoSeMovimentaAoNaoMatar(){

        Campo campo = new Campo();

        Rodriguinho rodriguinho = new Rodriguinho();
        Claudinho claudinho = new Claudinho();

        campo.inserir(rodriguinho, 3);
        campo.inserir(claudinho,2);


        claudinho.getClasse().buscaVitima(rodriguinho, campo, rodriguinho.getPosicaoAtual());
        Assert.assertEquals("| | |A|R| | | | | | |", campo.exibir());


    }

    @Test
    public void rodriguinhoAtacaESeMovimentaAoMatar(){

        Campo campo = new Campo();

        Rodriguinho rodriguinho = new Rodriguinho();
        Claudinho claudinho = new Claudinho();

        campo.inserir(rodriguinho, 3);
        campo.inserir(claudinho,2);

        claudinho.setConstituicao(14);


        claudinho.getClasse().buscaVitima(rodriguinho, campo, rodriguinho.getPosicaoAtual());
        Assert.assertEquals("| | |R| | | | | | | |", campo.exibir());


    }

    @Test
    public void lineuzinhoAtacaESeMovimenta(){

        Campo campo = new Campo();

        Lineuzinho lineuzinho = new Lineuzinho();
        Padinho padinho = new Padinho();

        campo.inserir(lineuzinho,0);
        campo.inserir(padinho,7);

        padinho.setConstituicao(10);

        lineuzinho.getClasse().buscaVitima(lineuzinho, campo, lineuzinho.getPosicaoAtual());

        Assert.assertEquals("| |Z| | | | | | | | |", campo.exibir());

    }

    @Test
    public void lineuzinhoAtacaESeNaoMovimenta(){

        Campo campo = new Campo();

        Lineuzinho lineuzinho = new Lineuzinho();
        Padinho padinho = new Padinho();
        Rodriguinho rodriguinho = new Rodriguinho();

        campo.inserir(lineuzinho,0);
        campo.inserir(padinho,5);
        campo.inserir(rodriguinho, 8);

        padinho.setConstituicao(10);

        lineuzinho.getClasse().buscaVitima(lineuzinho, campo, lineuzinho.getPosicaoAtual());

        Assert.assertEquals("|Z| | | | | | | |R| |", campo.exibir());

    }

    @Test
    public void carlinhosAtacaESeNaoMovimenta(){

        Campo campo = new Campo();

        Carlinhos carlinhos = new Carlinhos();
        Marquinhos marquinhos = new Marquinhos();
        Claudinho claudinho = new Claudinho();

        campo.inserir(carlinhos,9);
        campo.inserir(marquinhos,3);
        campo.inserir(claudinho, 0);

        marquinhos.setConstituicao(9);

        carlinhos.getClasse().buscaVitima(carlinhos, campo, carlinhos.getPosicaoAtual());

        Assert.assertEquals("|A| | | | | | | | |C|", campo.exibir());

    }

    @Test
    public void carlinhosAtacaESeMovimenta(){

        Campo campo = new Campo();

        Carlinhos carlinhos = new Carlinhos();
        Marquinhos marquinhos = new Marquinhos();


        campo.inserir(carlinhos,9);
        campo.inserir(marquinhos,3);


        marquinhos.setConstituicao(9);

        carlinhos.getClasse().buscaVitima(carlinhos, campo, carlinhos.getPosicaoAtual());

        Assert.assertEquals("| | | | | | | | |C| |", campo.exibir());

    }

}