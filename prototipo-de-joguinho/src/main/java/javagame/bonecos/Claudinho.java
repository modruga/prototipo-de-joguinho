package javagame.bonecos;

import javagame.classes.Porradeiro;
import javagame.origens.Floriano;

public class Claudinho extends Boneco implements Floriano {

    private boolean estaBebado = false;
    private int golesDados = 0;

    public Claudinho() {
        super(Equipe.COM_CAMISA, new Porradeiro(), 9, 2, 4, 60);
    }

    @Override
    public String toString() {
        return "A";
    }

    @Override
    public void beber() {
        golesDados++;
        if (golesDados >= 3) estaBebado = true;
    }

    @Override
    public String falar() {
        return estaBebado ? "Tens Gudang pra apoiar?" : "Po feio. Es um baita.";
    }
}
