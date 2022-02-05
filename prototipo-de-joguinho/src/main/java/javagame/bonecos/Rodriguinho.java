package javagame.bonecos;

import javagame.classes.Porradeiro;
import javagame.origens.Maligno;

public class Rodriguinho extends Boneco implements Maligno {

    public Rodriguinho() {
        super(Equipe.SEM_CAMISA, new Porradeiro(), 7, 4, 1, 30);
    }

    @Override
    public String grunir() {
        return "AWOOOOOOO!";
    }

    @Override
    public String toString() {
        return "R";
    }

}
