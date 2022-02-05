package javagame.bonecos;

import javagame.classes.Bombardeiro;
import javagame.origens.Fenix;

public class Lineuzinho extends Boneco implements Fenix {

    public Lineuzinho() {
        super(Equipe.COM_CAMISA, new Bombardeiro(),2, 3, 10, 80);
    }

    @Override
    public Fenix ressucitar() {
        return new Lineuzinho();
    }

    @Override
    public String toString() {
        return "Z";
    }

    @Override
    public String falar() {
        return "Pelo amor de deus, Tuco.";
    }
}
