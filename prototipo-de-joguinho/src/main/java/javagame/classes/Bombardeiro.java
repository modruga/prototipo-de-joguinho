package javagame.classes;

import javagame.bonecos.Equipe;
import javagame.bonecos.Boneco;
import javagame.logisticadecombate.Campo;

public class Bombardeiro implements Classe {

    @Override
    public Campo atacar(Boneco bonecoAtacante, Boneco bonecoAtacado, Campo campoAtual, int posicaoAtacante, int distancia) {

        Boneco[] mapa = campoAtual.getMapa();

        bonecoAtacado.setConstituicao(bonecoAtacado.getConstituicao() - bonecoAtacante.getInteligencia());

        if(bonecoAtacado.getConstituicao() <= 0){

            mapa[bonecoAtacado.getPosicaoAtual()] = null;
            campoAtual.setMapa(mapa);

        }

        return campoAtual;

    }

    @Override
    public Campo buscaVitima(Boneco bonecoAtacante, Campo campoAtual, int indice) {

        Boneco[] mapa = campoAtual.getMapa();

        if (bonecoAtacante.getEquipe() == Equipe.COM_CAMISA) {

            for (int i = indice; i < mapa.length; i++) {

                if (mapa[i] != null && mapa[i].getEquipe() == Equipe.SEM_CAMISA) {

                    campoAtual = bonecoAtacante.getClasse().atacar(bonecoAtacante, mapa[i], campoAtual, bonecoAtacante.getPosicaoAtual(), Math.abs(i - indice));

                    break;

                }

            }

            for (int i = 0; i < mapa.length; i++) {

                if(mapa[i] != null && !mapa[i].toString().equals(bonecoAtacante.toString())){
                    return campoAtual;
                }

            }

            if(mapa[indice+1] == null) {
                mapa[indice + 1] = mapa[indice];
                mapa[indice] = null;
                campoAtual.setMapa(mapa);
            }

            return campoAtual;

        }

        if(bonecoAtacante.getEquipe() == Equipe.SEM_CAMISA){

            for (int i = indice; i >= 0; i--) {

                if(mapa[i] != null && mapa[i].getEquipe() == Equipe.COM_CAMISA){

                    campoAtual = bonecoAtacante.getClasse().atacar(bonecoAtacante, mapa[i], campoAtual, bonecoAtacante.getPosicaoAtual(), Math.abs(i - indice));

                    break;

                }

            }

            for (int i = 9; i >= 0; i--) {

                if(mapa[i] != null && !mapa[i].toString().equals(bonecoAtacante.toString())){
                    return campoAtual;
                }

            }

            if(mapa[indice-1] == null) {
                mapa[indice - 1] = mapa[indice];
                mapa[indice] = null;
                campoAtual.setMapa(mapa);

                return campoAtual;
            }

        }

        return null;

    }
}
