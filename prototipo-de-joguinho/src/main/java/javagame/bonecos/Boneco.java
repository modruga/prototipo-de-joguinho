package javagame.bonecos;

import javagame.classes.Classe;

public class Boneco {

    private final int forca;
    private final int agilidade;
    private final int inteligencia;
    private int constituicao;

    private int posicaoAtual;

    private final Equipe equipe;
    private final Classe classe;

    public Boneco(Equipe equipe, Classe classe, int forca, int agilidade, int inteligencia, int constituicao) {
        this.equipe = equipe;
        this.classe = classe;
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.constituicao = constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getForca() {
        return forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void receberDano(int danoRecebido) {

        this.constituicao = this.constituicao - danoRecebido;

    }

    public Equipe getEquipe() {
        return equipe;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setPosicaoAtual(int posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }

    public int getPosicaoAtual() {
        return posicaoAtual;
    }

}
