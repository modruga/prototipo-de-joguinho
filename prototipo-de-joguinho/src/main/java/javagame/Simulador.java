package javagame;

import javagame.bonecos.Boneco;
import javagame.logisticadecombate.Campo;

import java.util.ArrayList;

public class Simulador {

    public void simular(Campo campo) {

        Boneco[] mapaJogado = campo.getMapa();
        int i = 0;
        int turnoAtual = 1;
        ArrayList<String> jaJogouNoTurno = new ArrayList<String>();

        while (campo.fimDeJogo(campo) == null) {

            if (mapaJogado[i] != null) {

                if (jaJogouNoTurno.contains(mapaJogado[i].toString())) {
                    i++;
                }

                if (mapaJogado[i] != null) {
                    jaJogouNoTurno.add(campo.getMapa()[i].toString());
                    mapaJogado[i].getClasse().buscaVitima(mapaJogado[i], campo, i);
                }

            }

            i++;

            if (i == 10) {
                i = 0;
                jaJogouNoTurno.clear();
                turnoAtual++;
            }

        }

    }

}
