package javagame.classes;

import javagame.bonecos.Boneco;
import javagame.logisticadecombate.Campo;

public interface Classe {

    Campo atacar(Boneco bonecoAtacante, Boneco bonecoAtacado, Campo campoAtual, int posicaoAtacante, int distancia);
    Campo buscaVitima(Boneco bonecoAtacante, Campo campoAtual, int indice);

}
