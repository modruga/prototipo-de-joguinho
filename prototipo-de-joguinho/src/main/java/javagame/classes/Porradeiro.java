package javagame.classes;

import javagame.logisticadecombate.Campo;
import javagame.bonecos.Equipe;
import javagame.bonecos.Boneco;

public class Porradeiro implements Classe {


    @Override
    public Campo buscaVitima(Boneco bonecoAtacante, Campo campoAtual, int indice) {
        Boneco[] mapa = campoAtual.getMapa();

        if (bonecoAtacante.getEquipe() == Equipe.COM_CAMISA) {

            if (mapa[indice + 1] != null && mapa[indice + 1].getEquipe() == Equipe.SEM_CAMISA) {

                campoAtual = bonecoAtacante.getClasse().atacar(bonecoAtacante, mapa[indice + 1], campoAtual, bonecoAtacante.getPosicaoAtual(), 1);
                mapa = campoAtual.getMapa();

                if (mapa[indice + 1] == null) {

                    mapa[indice + 1] = mapa[indice];
                    mapa[indice] = null;

                    bonecoAtacante.setPosicaoAtual(indice + 1);

                    campoAtual.setMapa(mapa);
                    return campoAtual;

                }

                return campoAtual;


            }

            if (mapa[indice + 1] == null) {

                mapa[indice + 1] = mapa[indice];
                mapa[indice] = null;
                bonecoAtacante.setPosicaoAtual(indice + 1);
                campoAtual.setMapa(mapa);
                return campoAtual;

            }

        } else {

            if (mapa[indice - 1] != null && mapa[indice - 1].getEquipe() == Equipe.COM_CAMISA) {

                bonecoAtacante.getClasse().atacar(bonecoAtacante, mapa[indice - 1], campoAtual, bonecoAtacante.getPosicaoAtual(), 1);
                mapa = campoAtual.getMapa();

                if (mapa[indice - 1] == null) {

                    mapa[indice - 1] = mapa[indice];
                    mapa[indice] = null;

                    bonecoAtacante.setPosicaoAtual(indice - 1);

                    campoAtual.setMapa(mapa);
                    return campoAtual;

                }

                return campoAtual;

            }

            if (mapa[indice - 1] == null) {

                mapa[indice - 1] = mapa[indice];
                mapa[indice] = null;
                bonecoAtacante.setPosicaoAtual(indice - 1);
                campoAtual.setMapa(mapa);
                return campoAtual;

            }

        }

        return null;

    }

    @Override
    public Campo atacar(Boneco bonecoAtacante, Boneco bonecoAtacado, Campo campoAtual, int posicaoAtacante, int distancia) {

        Boneco[] mapa = campoAtual.getMapa();

        bonecoAtacado.receberDano(2 * bonecoAtacante.getForca());

        if (bonecoAtacado.getConstituicao() <= 0 && bonecoAtacante.getEquipe() == Equipe.COM_CAMISA) {

            mapa[posicaoAtacante + distancia] = null;
            campoAtual.setMapa(mapa);

            return campoAtual;

        }

        if (bonecoAtacado.getConstituicao() <= 0 && bonecoAtacante.getEquipe() == Equipe.SEM_CAMISA) {

            mapa[posicaoAtacante - distancia] = null;
            campoAtual.setMapa(mapa);

            return campoAtual;

        }

        return campoAtual;
    }


}
