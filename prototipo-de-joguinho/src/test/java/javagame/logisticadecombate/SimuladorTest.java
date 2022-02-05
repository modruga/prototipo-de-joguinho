package javagame.logisticadecombate;

import javagame.bonecos.*;
import org.junit.Assert;
import org.junit.Test;
import javagame.Simulador;

public class SimuladorTest {

    @Test
    public void testeSimulador() {

        Campo campo = new Campo();

        Lineuzinho lineuzinho = new Lineuzinho();
        Marquinhos marquinhos = new Marquinhos();
        Carlinhos carlinhos = new Carlinhos();
        Rodriguinho rodriguinho = new Rodriguinho();

        campo.inserir(lineuzinho, 0);
        campo.inserir(marquinhos, 2);
        campo.inserir(carlinhos, 9);
        campo.inserir(rodriguinho, 6);

        Simulador simulacao = new Simulador();

        simulacao.simular(campo);

    }

    @Test
    public void deveVencerComCamisaQuandoJoaozinhoEMarquinhosBatalharemContraRodriguinhoEPadinho()
            throws BonecoRepetidoException, CasaIndisponivelException, SemCamisaVenceramException, BonecoNaoExisteException {

        String resultadoEsperado = "| | | | |J| | | | |M|";

        Joaozinho joaozinho = new Joaozinho();
        Marquinhos marquinhos = new Marquinhos();
        Rodriguinho rodriguinho = new Rodriguinho();
        Padinho padinho = new Padinho();
        Campo campo = new Campo();
        Simulador simulador = new Simulador();

        campo.inserir(joaozinho, 0);
        campo.inserir(marquinhos, 1);
        campo.inserir(rodriguinho, 7);
        campo.inserir(padinho, 9);
        simulador.simular(campo);

        Assert.assertEquals(resultadoEsperado, campo.exibir());
    }

    @Test(expected = SemCamisaVenceramException.class)
    public void deveLancarSemCamisaVenceramExceptionExceptionQuandoInimigosDerrotaremComCamisa()
            throws BonecoRepetidoException, CasaIndisponivelException, SemCamisaVenceramException, BonecoNaoExisteException {
        // Início: "|A| |I| | | | |U|O|G|"
        // Fim:    "| | | | | | |O|M| | |"

        Joaozinho joaozinho = new Joaozinho();
        Claudinho claudinho = new Claudinho();
        Leozinho leozinho = new Leozinho();
        Rodriguinho rodriguinho = new Rodriguinho();
        Padinho padinho = new Padinho();
        Campo campo = new Campo();
        Simulador simulador = new Simulador();

        campo.inserir(joaozinho, 0);
        campo.inserir(claudinho, 2);
        campo.inserir(leozinho, 7);
        campo.inserir(rodriguinho, 8);
        campo.inserir(padinho, 9);
        simulador.simular(campo);

    }

    @Test
    public void deveVencerComCamisaQuandoLineuzinhoBatalharSozinhoContraCarlinhos()
            throws BonecoRepetidoException, CasaIndisponivelException, SemCamisaVenceramException, BonecoNaoExisteException {
        // Início:  "|G| | | | | | | | |S|"
        String resultadoEsperado = "| | | | | | | | | |Z|";

        Lineuzinho lineuzinho = new Lineuzinho();
        Carlinhos carlinhos = new Carlinhos();
        Campo campo = new Campo();
        Simulador simulador = new Simulador();

        campo.inserir(lineuzinho, 0);
        campo.inserir(carlinhos, 9);
        simulador.simular(campo);

        Assert.assertEquals(resultadoEsperado, campo.exibir());
    }

    @Test(expected = SemCamisaVenceramException.class)
    public void deveLancarSemCamisaVenceramExceptionQuandoMarquinhosBatalharSozinhoContraRodriguinhoELeozinho()
            throws BonecoRepetidoException, CasaIndisponivelException, SemCamisaVenceramException, BonecoNaoExisteException {

        Marquinhos marquinhos = new Marquinhos();
        Rodriguinho rodriguinho = new Rodriguinho();
        Leozinho leozinho = new Leozinho();
        Campo campo = new Campo();
        Simulador simulador = new Simulador();

        campo.inserir(marquinhos, 0);
        campo.inserir(leozinho, 8);
        campo.inserir(rodriguinho, 9);
        simulador.simular(campo);
    }

    @Test(expected = SemCamisaVenceramException.class)
    public void deveLancarSemCamisaVenceramExceptionQuandoBetinhoBatalharSozinhoContraLeozinho()
            throws BonecoRepetidoException, CasaIndisponivelException, SemCamisaVenceramException, BonecoNaoExisteException {

        Betinho betinho = new Betinho();
        Leozinho leozinho = new Leozinho();
        Campo campo = new Campo();
        Simulador simulador = new Simulador();

        campo.inserir(betinho,0);
        campo.inserir(leozinho,9);
        simulador.simular(campo);
    }

    @Test(expected = CasaIndisponivelException.class)
    public void deveLancarCasaIndisponivelExceptionAoInserirDoisBonecosNaMesmaCasa()
            throws BonecoRepetidoException, CasaIndisponivelException, SemCamisaVenceramException, BonecoNaoExisteException {

        Joaozinho joaozinho = new Joaozinho();
        Claudinho claudinho = new Claudinho();

        Campo campo = new Campo();

        Simulador simulador = new Simulador();

        campo.inserir(joaozinho, 0);
        campo.inserir(claudinho, 0);

        simulador.simular(campo);

    }

    @Test(expected = BonecoRepetidoException.class)
    public void deveLancarBonecoRepetidoExceptionAoColocarDoisBonecosIguais()
            throws BonecoRepetidoException, CasaIndisponivelException, SemCamisaVenceramException, BonecoNaoExisteException {
        // Início: "|A| |I| | | | |U|O|G|"
        // Fim:    "| | | | | | |O|M| | |"

        Joaozinho joaozinho = new Joaozinho();
        Joaozinho joaozinho2 = new Joaozinho();

        Campo campo = new Campo();

        Simulador simulador = new Simulador();

        campo.inserir(joaozinho, 0);
        campo.inserir(joaozinho2, 3);

        simulador.simular(campo);

    }

}
