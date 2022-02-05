package javagame.logisticadecombate;

import javagame.bonecos.Equipe;
import javagame.bonecos.Boneco;

public class Campo {

    Boneco[] mapa = new Boneco[10];

    public String exibir() {

        StringBuilder exibicaoLista = new StringBuilder("|");

        for (Boneco boneco : mapa) {

            if (boneco == null || boneco.getConstituicao() == 0) {

                exibicaoLista.append(" ");

            } else {

                exibicaoLista.append(boneco.toString());

            }

            exibicaoLista.append("|");

        }

        return exibicaoLista.toString();

    }

    public void inserir(Boneco boneco, int posicao) {

        if (existePersonagemNaLista(boneco)) {
            throw new BonecoRepetidoException();
        }

        if (mapa[posicao] != null) throw new CasaIndisponivelException();
        mapa[posicao] = boneco;
        boneco.setPosicaoAtual(posicao);
    }

    public int buscarPosicao(Boneco boneco) {

        for (int i = 0; i < mapa.length; i++) {

            if (mapa[i] != null) {
                if (boneco.toString().equals(mapa[i].toString())) {

                    return i;

                }

            }
        }

        throw new BonecoNaoExisteException();

    }

    public boolean existePersonagemNaLista(Boneco boneco) {

        for (Boneco value : mapa) {

            if (value != null) {
                if (boneco.toString().equals(value.toString())) {

                    return true;

                }
            }
        }

        return false;

    }

    public Boneco buscarCasa(int posicao) {

        if (mapa[posicao] != null) {

            return mapa[posicao];

        }

        return null;

    }

    public Boneco[] getMapa() {
        return mapa;
    }

    public void setMapa(Boneco[] mapa) {
        this.mapa = mapa;
    }

    public String fimDeJogo(Campo campoAtual){

        Boneco[] mapa = campoAtual.getMapa();

        boolean temPersonagem = false;

        for (Boneco boneco : mapa) {

            if (boneco != null && boneco.getEquipe() == Equipe.COM_CAMISA) {
                temPersonagem = true;
                break;
            }

        }

        if(!temPersonagem){

            throw new SemCamisaVenceramException();

        }


        if(mapa[0] != null && mapa[0].getEquipe() == Equipe.SEM_CAMISA){

        throw new SemCamisaVenceramException();

        }

        if(mapa[9] != null && mapa[9].getEquipe() == Equipe.COM_CAMISA){

            return "VitoriaComCamisa";

        }

        return null;

    }

}





