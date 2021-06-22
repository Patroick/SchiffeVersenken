package Klassen;

import java.util.Scanner;

import Exceptions.InvalidIndexException;
import Exceptions.InvalidInputException;

/**
 * Subklasse von Spieler implementiert platziereSchiffe und angriff
 */

public class SpielerMensch extends Spieler {

    /**
     * Konstruktor der Klasse SpielerMensch der ein Spielfeld mit den übergeben paramtern erstellt
     *
     * @param groesse
     * @param name
     */
    public SpielerMensch(int groesse, String name) {
        super(groesse, name);
    }

    /**
     * Methode in der Unser Input abgefragt wird und an die Methode setzeSchiffe der Klasse Spielfeld übergeben wird.
     */
    @Override
    public void platziereSchiffe() {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= spielfeld.getSchiffe().size(); ) {
            System.out.println(spielfeld.getName() + " platziert nun sein " + i + " Schiff mit der Länge " + spielfeld.getSchiffe()
                    .get(i - 1).getLaenge() + ".");
            System.out.println("Geben Sie nun die gewünschte X Koordinate Ihres Schiffes ein: ");
            int x = sc.nextInt() - 1;
            System.out.println("Geben Sie nun die gewünschte Y Koordinate Ihres Schiffes ein: ");
            int y = sc.nextInt() - 1;
            System.out.println("Geben Sie die Richtung des Schiffes ein. [oben] [unten] [rechts] [links]");
            String richtung = sc.next();
            try {
                if (spielfeld.pruefeSpielfeld(x, y, richtung, spielfeld.getSchiffe().get(i - 1))) {
                    spielfeld.setzeSchiffe(x, y, richtung, spielfeld.getSchiffe().get(i-1));
                    i++;
                } else {
                    continue;
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                continue;
            }
            spielfeld.anzeigenSpielfeld(spielfeld.getArraySpielfeld());
        }
    }

    /**
     * Methode in der Unser Input abgefragt wird und an die Methode getroffen der Klasse Spieler übergeben wird.
     * @param gegner
     */

    @Override
    public void angriff(Spieler gegner) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Geben Sie die X Koordinate ein auf die Sie feuern wollen: ");
        int x = sc.nextInt() - 1;
        System.out.println("Geben Sie die Y Koordinate ein auf die Sie feuern wollen: ");
        int y = sc.nextInt() - 1;

        gegner.getroffen(x, y);


    }


}

