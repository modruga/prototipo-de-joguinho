package javagame.bonecos;

import javagame.origens.Pitaiense;
import javagame.classes.Porradeiro;

public class Betinho extends Boneco implements Pitaiense {

    public Betinho() {
        super(Equipe.COM_CAMISA, new Porradeiro(), 7, 6, 3, 40);
    }


    @Override
    public String falar() {
        return "E como isso afeta o gremio.";
    }

    @Override
    public void amadurecer() {
        super.setConstituicao(super.getConstituicao() - 2);
    }

    @Override
    public String toString() {
        return "B";
    }

}
