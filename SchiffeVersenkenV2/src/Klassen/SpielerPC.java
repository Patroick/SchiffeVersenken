package Klassen;

import Exceptions.InvalidInputException;

import java.util.Random;

/**
 * Subklasse von Spieler implementiert platziereSchiffe und angriff
 */

public class SpielerPC extends Spieler{

    /**
     * Konstruktor der Klasse SpielerPC der ein Spielfeld mit den übergeben paramtern erstellt
     *
     * @param groesse
     * @param name
     */
    public SpielerPC(int groesse, String name) {
        super(groesse, name);
    }

    /**
     * Methode die zufällig Schiffe auf dem Spielfeld platziert
     */
    @Override
    public void platziereSchiffe(){
        String[] richtungen = {"rechts","unten","links","oben"};
        Random rand = new Random();
        for(int i = 0; i < spielfeld.getSchiffe().size();){
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            String richtung = richtungen[rand.nextInt(4)];

            try {
                if(spielfeld.pruefeSpielfeld(x, y, richtung, spielfeld.getSchiffe().get(i))) {
                    spielfeld.setzeSchiffe(x, y, richtung, spielfeld.getSchiffe().get(i));
                    i++;
                }
            } catch (InvalidInputException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Methode die zufällig auf dem Spielfeld angreift
     * @param gegner
     */
    @Override
    void angriff(Spieler gegner) {
        if(!pruefeGameOver()) {
            Random rand = new Random();
            System.out.println("\n" + spielfeld.getName() + " greift an.");
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            gegner.getroffen(x, y);
        }
    }

}
