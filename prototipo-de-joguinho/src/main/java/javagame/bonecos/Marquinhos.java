package javagame.bonecos;

import javagame.classes.Budoqueiro;
import javagame.origens.Cenoures;

public class Marquinhos extends Boneco implements Cenoures {

    public Marquinhos() {
        super(Equipe.COM_CAMISA, new Budoqueiro(), 5, 10, 6, 80);
    }

    @Override
    public String dialogarEsquisito() {
        return "Tomaerd delas Gurelas!";
    }

    @Override
    public String toString() {
        return "M";
    }

    @Override
    public String falar() {
        return "Velocidade!";
    }
}
