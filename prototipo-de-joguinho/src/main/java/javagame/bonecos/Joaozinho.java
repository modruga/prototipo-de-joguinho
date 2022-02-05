package javagame.bonecos;

import javagame.classes.Porradeiro;
import javagame.origens.Pitaiense;

public class Joaozinho extends Boneco implements Pitaiense {

    public Joaozinho() {

        super(Equipe.COM_CAMISA, new Porradeiro(), 10, 7, 6, 60);

    }

    @Override
    public void amadurecer() {
        super.setConstituicao(super.getConstituicao() - 1);
    }

    @Override
    public String falar() {
        return "Zoio, Zovido, Zunha.";
    }

    @Override
    public String toString() {
        return "J";
    }

}
