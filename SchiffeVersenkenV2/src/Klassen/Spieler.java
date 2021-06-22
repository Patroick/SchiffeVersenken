package Klassen;

import Exceptions.InvalidIndexException;
import Enum.Symbol;

/**
 * Abstrakte Klasse um Spielerlogik wie angreifen oder Schiffe platzieren zu definieren
 */

abstract class Spieler {

    protected Spielfeld spielfeld;

    /**
     * Konstruktor
     */
    public Spieler(int groesse, String name){
        spielfeld = new Spielfeld(groesse, name);
    }

    /**
     * Abstrakte Methode die in SpielerMensch und SpielerPC implementiert wird
     */
    abstract void platziereSchiffe();

    /**
     * Abstrakte Methode die in SpielerMensch und SpielerPC implementiert wird
     *
     * @param gegner
     */
    abstract void angriff(Spieler gegner);


    /**
     * Methode um zu prüfen ob der Spieler Game Over ist
     *
     * @return boolean
     */
    public boolean pruefeGameOver(){
        int schiffe = 0;
        for (int i = 0; i < spielfeld.getArraySpielfeld().length; i++) {
            for (int j = 0; j < spielfeld.getArraySpielfeld()[i].length; j++) {
                if (spielfeld.getArraySpielfeld()[i][j].equals(Symbol.SCHIFF)) {
                    schiffe++;
                }
            }
        }
        if (schiffe == 0) {
            return true;
        }
        return false;
    }

    /**
     * Methode die verwendet wird wenn der Spieler angegriffen wurde
     *
     * @param x
     * @param y
     */

    public void getroffen(int x, int y){
        try {
            if(this.spielfeld.pruefeSpielfeld(x, y)){
                if (!this.pruefeGameOver()) {
                    //Wenn das Feld ein Schiff ist das Schiff durch ein Treffer Symbol ersetzt.

                    if (this.getSpielfeld().getArraySpielfeld()[y][x].equals(Symbol.SCHIFF)) {
                        this.spielfeld.setArraySpielfeld(x, y, Symbol.TREFFER);
                        this.spielfeld.setArraySpielfeldOhneSchiffe(x, y, Symbol.TREFFER);
                    } else {
                        this.spielfeld.setArraySpielfeld(x, y, Symbol.SCHUSS);
                        this.spielfeld.setArraySpielfeldOhneSchiffe(x, y, Symbol.SCHUSS);
                    }

                    //Spielfeld wird auf der Konsole ausgegeben.
                    this.spielfeld.anzeigenSpielfeld(this.spielfeld.getArraySpielfeldOhneSchiffe());

                }
            }
        } catch (InvalidIndexException e) {
            System.out.println(e.getMessage());
            angriff(this);
        }
    }

    //Getter und Setter

    public Spielfeld getSpielfeld() {
        return spielfeld;
    }
    public void setSpielfeld(Spielfeld spielfeld) {
        this.spielfeld = spielfeld;
    }
}
