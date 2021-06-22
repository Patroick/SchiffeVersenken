package Klassen;

import Enum.Symbol;
import Exceptions.InvalidIndexException;
import Exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Klasse Spielfeld die das Spielfeld für Schiffe Versenken implementiert
 */

public class Spielfeld {

    //Arraylist in der die Anzahl an Schiffen gespeichert werden
    private ArrayList<Schiff> schiffe;
    //Hier zwei Arrays da im 2 Spieler Modus das Spielfeld auch ohne Schiffe ausgegebn werden muss.
    private Symbol[][] arraySpielfeld;
    private Symbol[][] arraySpielfeldOhneSchiffe;
    private String name;

    /**
     * Konstruktor für die Klasse Spielfeld in der die beien Arrays und die Schiffe ArrayList gefüllt werden
     *
     * @param groesse
     * @param name
     */

    public Spielfeld(int groesse, String name) {
        this.name = name;
        arraySpielfeld = new Symbol[groesse][groesse];
        arraySpielfeldOhneSchiffe = new Symbol[groesse][groesse];
        schiffe = new ArrayList<>();
        for (int i = 0; i < arraySpielfeld.length; i++) {
            Arrays.fill(arraySpielfeld[i], Symbol.WASSER);
        }
        for (int i = 0; i < arraySpielfeldOhneSchiffe.length; i++) {
            Arrays.fill(arraySpielfeldOhneSchiffe[i], Symbol.WASSER);
        }

        for (int i = 0; i < 1; i++) {
            Schiff schiff = new Schiff(3);
            schiffe.add(schiff);
        }
    }
    //Methoden

    /**
     * Methode um Schiffe auf die mitgegebenen Koordinaten zu setzen
     *
     * @param x
     * @param y
     * @param richtung
     * @param schiff
     * @throws InvalidInputException
     */
    public void setzeSchiffe(int x, int y, String richtung, Schiff schiff) throws InvalidInputException {
        if (pruefeSpielfeld(x, y, richtung, schiff)) {
            for (int n = 0; n < schiff.getLaenge(); n++) {
                switch (richtung) {
                    case "rechts":
                        arraySpielfeld[y][x + n] = Symbol.SCHIFF;
                        break;
                    case "unten":
                        arraySpielfeld[y + n][x] = Symbol.SCHIFF;
                        break;
                    case "links":
                        arraySpielfeld[y][x - n] = Symbol.SCHIFF;
                        break;
                    case "oben":
                        arraySpielfeld[y - n][x] = Symbol.SCHIFF;
                        break;
                }
            }
        }
    }

    /**
     * Methode um die Arrays auf der Konsole auszugeben
     *
     * @param arraySpielfeld
     */
    public void anzeigenSpielfeld(Symbol[][] arraySpielfeld) {
        //Hier wird ober dem Spielfeld ein Koordinatensystem in der Konsole ausgegeben.
        System.out.println("\n" + this.name);
        System.out.print("   ");
        for (int i = 1; i <= arraySpielfeld.length; i++) {
            System.out.print(i + "  ");
        }
        System.out.println("→X");

        //Hier wird links neben dem Spielfeld ein Koordinatensystem und das Spielfeld ausgegeben.
        //Ausgabe des Koordinatensystems
        for (int i = 0; i < arraySpielfeld.length; i++) {
            if (i < 9) {
                System.out.print(i + 1 + " |");
            } else {
                System.out.print(i + 1 + "|");
            }
            //Ausgabe des Spielfelds
            for (int j = 0; j < arraySpielfeld[i].length; j++) {
                System.out.print(arraySpielfeld[i][j].getSymbol() + "  ");
            }
            System.out.println("");

        }
        System.out.println("↓\nY");
    }

    /**
     * Methode um zu prüfen ob die mitgegebenen Koordinaten innerhalb des Arrays liegen
     *
     * @param x
     * @param y
     * @param richtung
     * @param schiff
     * @return boolean
     * @throws InvalidInputException
     */

    public boolean pruefeSpielfeld(int x, int y, String richtung, Schiff schiff) throws InvalidInputException {
        int count = 0;

        //Bevor ein Schiffe platziert wird, wird geprüft ob es innerhalb des Arrays ist und dass noch kein Schiff auf dem
        //Feld liegt.

        for (int i = 0; i < schiff.getLaenge(); i++) {
            if (richtung.equals("rechts") && ((x + i) >= 0 && (x + i) < arraySpielfeld.length) && (y >= 0 && y < arraySpielfeld.length) && (arraySpielfeld[y][x + i].equals(Symbol.WASSER))) {
                count++;
            } else if (richtung.equals("unten") && (x >= 0 && x < arraySpielfeld.length) && ((y + i) >= 0 && (y + i) < arraySpielfeld.length) && (arraySpielfeld[y + i][x].equals(Symbol.WASSER))) {
                count++;
            } else if (richtung.equals("links") && ((x - i) >= 0 && (x - i) < arraySpielfeld.length) && (y >= 0 && y < arraySpielfeld.length) && (arraySpielfeld[y][x - i].equals(Symbol.WASSER))) {
                count++;
            } else if (richtung.equals("oben") && (x >= 0 && x < arraySpielfeld.length) && ((y - i) >= 0 && (y - i) < arraySpielfeld.length) && (arraySpielfeld[y - i][x].equals(Symbol.WASSER))) {
                count++;
            } else {
                throw new InvalidInputException();
            }

        }

        return count == schiff.getLaenge();
    }

    /**
     * Methode um zu prüfen ob die mitgegebenen Koordinaten innerhalb des Arrays liegen
     *
     * @param x
     * @param y
     * @return boolean
     * @throws InvalidIndexException
     */

    public boolean pruefeSpielfeld(int x, int y) throws InvalidIndexException {
        if (x < arraySpielfeld.length && y < arraySpielfeld.length) {
            if (arraySpielfeld[y][x].equals(Symbol.WASSER) || arraySpielfeld[y][x].equals(Symbol.SCHIFF)) {
                return true;
            } else {
                throw new InvalidIndexException();
            }
        } else {
            throw new InvalidIndexException();
        }
    }

    //Getter und Setter

    public ArrayList<Schiff> getSchiffe() {
        return schiffe;
    }

    public void setSchiffe(ArrayList<Schiff> schiffe) {
        this.schiffe = schiffe;
    }

    public Symbol[][] getArraySpielfeld() {
        return arraySpielfeld;
    }

    public void setArraySpielfeld(int x, int y, Symbol symbol) {
        this.arraySpielfeld[y][x] = symbol;
    }

    public String getName() {
        return name;
    }

    public Symbol[][] getArraySpielfeldOhneSchiffe() {
        return arraySpielfeldOhneSchiffe;
    }

    public void setArraySpielfeldOhneSchiffe(int x, int y, Symbol symbol) {
        this.arraySpielfeldOhneSchiffe[y][x] = symbol;
    }
}
