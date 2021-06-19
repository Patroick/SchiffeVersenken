package Klassen;

import java.util.Scanner;

import Enum.Symbol;
import Exceptions.AlreadyHitException;

public class SpielerMensch extends Spieler {

    public SpielerMensch(int groesse, String name) {
        spielfeld = new SpielfeldMensch(groesse, name);
    }

    public void platziereSchiffe() {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        for (int n = 0; i <= spielfeld.getSchiffe().size(); ) {
            System.out.println("Sie platzieren nun Ihr " + i + " Schiff mit der Länge " + spielfeld.getSchiffe().get(n).getLaenge() + ".");
            System.out.println("Geben Sie nun die gewünschte X Koordinate Ihres Schiffes ein: ");
            int x = sc.nextInt() - 1;
            System.out.println("Geben Sie nun die gewünschte Y Koordinate Ihres Schiffes ein: ");
            int y = sc.nextInt() - 1;
            System.out.println("Geben Sie die Richtung des Schiffes ein. [oben] [unten] [rechts] [links]");
            String richtung = sc.next();

            if (spielfeld.pruefeSpielfeld(x, y, richtung, spielfeld.getSchiffe().get(n))) {
                spielfeld.setzeSchiffe(x, y, richtung, spielfeld.getSchiffe().get(n));
                n++;
                i++;
            } else { //Exception
                continue;
            }
            spielfeld.anzeigenSpielfeld();
        }
    }

    public void angriff(Spieler gegner, int x, int y) {

        if (!pruefeGameOver()) {
            Scanner sc = new Scanner(System.in);

            //Wenn das Feld ein Schiff ist das Schiff durch ein Treffer Symbol ersetzt.

            if (gegner.getSpielfeld().getArraySpielfeld()[y][x].equals(Symbol.SCHIFF)) {
                spielfeld.setSpielfeld(x, y, Symbol.TREFFER);
            } else {
                spielfeld.setSpielfeld(x, y, Symbol.SCHUSS);
            }

            //Spielfeld wird auf der Konsole ausgegeben.
            spielfeld.anzeigenSpielfeld();

        }
    }
}

