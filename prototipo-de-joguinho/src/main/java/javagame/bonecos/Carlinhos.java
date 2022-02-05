package javagame.bonecos;

import javagame.classes.Bombardeiro;
import javagame.origens.Fenix;

public class Carlinhos extends Boneco implements Fenix {

    public Carlinhos() {
        super(Equipe.SEM_CAMISA, new Bombardeiro(), 2, 2, 9, 70);
    }

    @Override
    public Fenix ressucitar() {
        return null;
    }

    @Override
    public String falar() {
        return "Passou do Barra acabou Porto Alegre.";
    }

    @Override
    public String toString() {
        return "C";
    }

}
