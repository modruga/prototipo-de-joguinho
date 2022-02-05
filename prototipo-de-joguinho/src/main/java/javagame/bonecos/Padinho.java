package javagame.bonecos;

import javagame.classes.Budoqueiro;
import javagame.origens.Maligno;

public class Padinho extends Boneco implements Maligno {

    public Padinho() {
        super(Equipe.SEM_CAMISA, new Budoqueiro(), 3, 6, 1, 20);
    }

    @Override
    public String grunir() {
        return "UUUUUUUUUUPALELEEEE!!";
    }

    @Override
    public String toString() {
        return "P";
    }

}
