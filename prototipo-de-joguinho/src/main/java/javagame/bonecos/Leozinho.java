package javagame.bonecos;

import javagame.classes.Porradeiro;
import javagame.origens.Pitaiense;
import javagame.origens.Maligno;

public class Leozinho extends Boneco implements Maligno, Pitaiense {

    public Leozinho() {
        super(Equipe.SEM_CAMISA, new Porradeiro(), 8, 6, 3, 45);
    }


    @Override
    public void amadurecer() {
        super.setConstituicao(super.getConstituicao() - 2);
    }

    @Override
    public String grunir() {
        return "Auuuugaaaa!!";
    }

    @Override
    public String falar() {
        return "Vai dar namoro hein...";
    }

    @Override
    public String toString() {
        return "L";
    }

}
