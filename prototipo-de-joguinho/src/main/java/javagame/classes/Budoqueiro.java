package javagame.classes;

import javagame.bonecos.Boneco;
import javagame.logisticadecombate.Campo;
import javagame.bonecos.Equipe;

public class Budoqueiro implements Classe {

    @Override
    public Campo atacar(Boneco bonecoAtacante, Boneco bonecoAtacado, Campo campoAtual, int posicaoAtacante, int distancia) {

        Boneco[] mapa = campoAtual.getMapa();

        bonecoAtacado.receberDano(bonecoAtacante.getAgilidade() * distancia);

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

    @Override
    public Campo buscaVitima(Boneco bonecoAtacante, Campo campoAtual, int indice) {

        // índice: recebe a posição atual do personagem atacante

        Boneco[] mapa = campoAtual.getMapa();

        // busca de alvos para personagens da equipe COM CAMISA
        if (bonecoAtacante.getEquipe() == Equipe.COM_CAMISA) {

            // casos específicos de comportamento de busca para os budoqueiros COM CAMISA:
            if (indice == 8) {

                if (mapa[indice + 1] != null) {

                    campoAtual = bonecoAtacante.getClasse().atacar(mapa[indice], mapa[indice + 1], campoAtual, indice, 1);

                    campoAtual = movimenta(bonecoAtacante, campoAtual, indice);

                    return campoAtual;


                } else {

                    campoAtual = movimenta(bonecoAtacante, campoAtual, indice);

                    return campoAtual;

                }

            }

            if (indice == 7) {

                for (int i = 2; i >= 1; i--) {

                    if (mapa[indice + i] != null && mapa[indice + i].getEquipe() != Equipe.COM_CAMISA) {

                        campoAtual = bonecoAtacante.getClasse().atacar(mapa[indice], mapa[indice + i], campoAtual, indice, 1);

                        campoAtual = movimenta(bonecoAtacante, campoAtual, indice);

                        return campoAtual;

                    }

                }

                campoAtual = movimenta(bonecoAtacante, campoAtual, indice);
                return campoAtual;

            }

            // casos comuns
            for (int i = 3; i >= 1; i--) {

                if (mapa[indice + i] != null && mapa[indice + i].getEquipe() != Equipe.COM_CAMISA) {

                    campoAtual = bonecoAtacante.getClasse().atacar(bonecoAtacante, mapa[indice + i], campoAtual, indice, i);

                    campoAtual = movimenta(bonecoAtacante, campoAtual,indice);

                    mapa = campoAtual.getMapa();
                    return campoAtual;


                }

            }

            campoAtual = movimenta(bonecoAtacante, campoAtual, indice);
            return campoAtual;


        } else {

            // busca e aquisição de alvos da equipe SEM CAMISA

            // caso específico pra não dar OutOfBounds
            if (indice == 1) {

                if (mapa[indice - 1] != null && mapa[indice - 1].getEquipe() == Equipe.COM_CAMISA) {

                    campoAtual = bonecoAtacante.getClasse().atacar(bonecoAtacante, mapa[indice - 1], campoAtual, indice, 1);

                    campoAtual = movimenta(bonecoAtacante, campoAtual, indice);

                    return campoAtual;

                }

                if (mapa[indice - 1] == null) {

                    mapa[indice - 1] = mapa[indice];
                    mapa[indice] = null;
                    campoAtual.setMapa(mapa);

                    return campoAtual;

                }

            }

            // caso específico pra não dar OutOfBounds
            if (indice == 2) {

                for (int i = 2; i >= 1; i--) {

                    if (mapa[indice - i] != null && mapa[indice - i].getEquipe() == Equipe.COM_CAMISA) {

                        campoAtual = atacar(bonecoAtacante, mapa[indice - i], campoAtual, indice, i);
                        campoAtual = movimenta(bonecoAtacante, campoAtual, indice);

                        return campoAtual;

                    }

                }

                campoAtual = movimenta(bonecoAtacante, campoAtual, indice);
                return campoAtual;

            }

            // casos comuns
            for (int i = 3; i >= 1; i--) {

                if (mapa[indice - i] != null && mapa[indice - i].getEquipe() == Equipe.COM_CAMISA) {

                    campoAtual = atacar(bonecoAtacante, mapa[indice - i], campoAtual, indice, i);
                    campoAtual = movimenta(bonecoAtacante, campoAtual, indice);

                    return campoAtual;

                }

            }

            campoAtual = movimenta(bonecoAtacante, campoAtual, indice);
            return campoAtual;

        }

    }

    public Campo movimenta(Boneco boneco, Campo campoAtual, int indice) {

        Boneco[] mapa = campoAtual.getMapa();

        if (boneco.getEquipe() == Equipe.COM_CAMISA) {

            if (indice == 8) {

                if (mapa[indice + 1] != null) {

                    return campoAtual;

                } else {

                    mapa[indice + 1] = mapa[indice];
                    mapa[indice] = null;

                    campoAtual.setMapa(mapa);
                    return campoAtual;

                }

            } else {

                if (mapa[indice + 1] == null && mapa[indice + 2] == null) {

                    mapa[indice + 2] = mapa[indice];
                    mapa[indice] = null;

                    campoAtual.setMapa(mapa);
                    return campoAtual;

                }

                if (mapa[indice + 1] == null) {

                    mapa[indice + 1] = mapa[indice];
                    mapa[indice] = null;

                    campoAtual.setMapa(mapa);
                    return campoAtual;

                }

            }
        }

        if (boneco.getEquipe() == Equipe.SEM_CAMISA) {



            if (indice == 1) {

                if (mapa[indice - 1] != null) {

                    return campoAtual;

                } else {

                    mapa[indice - 1] = mapa[indice];
                    mapa[indice] = null;

                    campoAtual.setMapa(mapa);
                    return campoAtual;

                }

            } else {

                if (mapa[indice - 1] == null && mapa[indice - 2] == null) {

                    mapa[indice - 2] = mapa[indice];
                    mapa[indice] = null;

                    campoAtual.setMapa(mapa);
                    return campoAtual;

                }

                if (mapa[indice - 1] == null) {

                    mapa[indice - 1] = mapa[indice];
                    mapa[indice] = null;

                    campoAtual.setMapa(mapa);
                    return campoAtual;

                }
            }
        }

        return campoAtual;

    }


}


