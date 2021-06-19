package Klassen;

import Enum.Symbol;
import Exceptions.AlreadyHitException;

import java.util.ArrayList;
import java.util.Arrays;

abstract class Spielfeld {

    protected ArrayList<Schiff> schiffe;
    protected Symbol[][] arraySpielfeld;
    protected String name;

    public Spielfeld(int groesse, String name) {
        this.name = name;
        arraySpielfeld = new Symbol[groesse][groesse];
        schiffe = new ArrayList<>();
        for (int i = 0; i < arraySpielfeld.length; i++) {
            Arrays.fill(arraySpielfeld[i], Symbol.WASSER);
        }

        for (int i = 0; i < 3; i++) {
            Schiff schiff = new Schiff(3);
            schiffe.add(schiff);
        }
    }


    //Methoden

    public void setzeSchiffe(int x, int y, String richtung, Schiff schiff) {
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

    public void anzeigenSpielfeld(){
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
            if(i < 9) {
                System.out.print(i + 1 + " |");
            } else{
                System.out.print(i + 1 + "|");
            }
            //Ausgabe des Spielfelds
            for (int j = 0; j < arraySpielfeld[i].length; j++) {
                printSpielfeld(j,i);
            }
            System.out.println("");

        }
        System.out.println("↓\nY");
    };

    abstract void printSpielfeld(int x, int y);

    public boolean pruefeSpielfeld(int x, int y, String richtung, Schiff schiff) {
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
            }
        }

        return count == schiff.getLaenge();
    }

    public boolean pruefeSpielfeld(int x, int y) throws AlreadyHitException, ArrayIndexOutOfBoundsException {
        if (x < arraySpielfeld.length && y < arraySpielfeld.length) {
            if (arraySpielfeld[y][x].equals(Symbol.WASSER) || arraySpielfeld[y][x].equals(Symbol.SCHIFF)) {
                return true;
            } else {
                throw new AlreadyHitException();
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
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

    public void setSpielfeld(int x, int y, Symbol symbol) {
        this.arraySpielfeld[y][x] = symbol;
    }

    public String getName() {
        return name;
    }
}
