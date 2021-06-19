package Klassen;

import Exceptions.AlreadyHitException;

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

            if(spielfeld.pruefeSpielfeld(x, y, richtung, spielfeld.getSchiffe().get(i))) {
                spielfeld.setzeSchiffe(x, y, richtung, spielfeld.getSchiffe().get(i));
                i++;
            }
        }
    }

    @Override
    void angriff(Spieler gegner) {
        if(!pruefeGameOver()) {
            int x;
            int y;
            System.out.println("\n" + spielfeld.getName() + " greift an.");

            //Einlesen der Koordinaten

            System.out.println("Geben Sie die X Koordinate ein auf die Sie feuern wollen: ");
            //Die Eingabe wird um 1 verringert da der Index des Arrays bei 0 startet.
            x = sc.nextInt() - 1;
            System.out.println("Geben Sie die Y Koordinate ein auf die Sie feuern wollen: ");
            y = sc.nextInt() - 1;

            //Wenn das Feld ein Schiff ist das Schiff durch ein Treffer Symbol ersetzt.
            try {
                if (spielfeld.pruefeSpielfeld(x, y)) {
                    if (spielfeld.getArraySpielfeld()[y][x].equals(Symbol.SCHIFF)) {
                        spielfeld.setSpielfeld(x, y, Symbol.TREFFER);
                    } else {
                        spielfeld.setSpielfeld(x, y, Symbol.SCHUSS);
                    }
                }
            } catch (AlreadyHitException e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Die eingegebene Koordinate liegt auserhalb des Spielfelds");
            }

            //Spielfeld wird auf der Konsole ausgegeben.
            spielfeld.anzeigenSpielfeld();

            //Hier wird geprüft ob der Spieler gewonnen hat.

    }

}
