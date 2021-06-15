package Klassen;

import java.util.Random;

public class SpielerPC extends Spieler{

    public SpielerPC(int groesse, String name) {
        spielfeld = new SpielfeldPC(groesse, name);
    }

    public void platziereSchiffe(){
        String[] richtungen = {"rechts","unten","links","oben"};
        Random rand = new Random();
        for(int i = 0; i < spielfeld.getSchiffe().size();){
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            String richtung = richtungen[rand.nextInt(4)];

            if(spielfeld.prüfeSpielfeld(x, y, richtung, spielfeld.getSchiffe().get(i))) {
                spielfeld.setzeSchiffe(x, y, richtung, spielfeld.getSchiffe().get(i));
                i++;
            } else {
                continue;
            }
        }
    }

}
