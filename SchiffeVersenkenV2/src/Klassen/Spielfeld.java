package Klassen;
import Enum.Symbol;

import java.util.ArrayList;

abstract class Spielfeld {

    protected ArrayList<Schiff> schiffe;
    protected String[][] spielfeld;
    protected String name;

    public Spielfeld(int groesse, String name){
        spielfeld = new String[groesse][groesse];
        schiffe = new ArrayList<>();
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                spielfeld[i][j] = Symbol.WASSER.getSymbol();
            }
        }

        for(int i = 0; i < 3; i++){
            Schiff schiff = new Schiff(3);
            schiffe.add(schiff);
        }
    }

    //Getter und Setter

    public ArrayList<Schiff> getSchiffe() {
        return schiffe;
    }

    public void setSchiffe(ArrayList<Schiff> schiffe) {
        this.schiffe = schiffe;
    }

    public String[][] getSpielfeld() {
        return spielfeld;
    }

    public void setSpielfeld(String[][] spielfeld) {
        this.spielfeld = spielfeld;
    }

    //

    public void setzeSchiffe(int x, int y, String richtung, Schiff schiff){
        if(prüfeSpielfeld(x,y,richtung,schiff)){
            for(int n = 0; n < schiff.getLaenge(); n++) {
                switch (richtung) {
                    case "rechts":
                        spielfeld[y][x + n] = Symbol.SCHIFF.getSymbol();
                        break;
                    case "unten":
                        spielfeld[y + n][x] = Symbol.SCHIFF.getSymbol();
                        break;
                    case "links":
                        spielfeld[y][x - n] = Symbol.SCHIFF.getSymbol();
                        break;
                    case "oben":
                        spielfeld[y - n][x] = Symbol.SCHIFF.getSymbol();
                        break;
                }
            }
        }
    }

    abstract void anzeigenSpielfeld();

    public boolean prüfeSpielfeld(int x, int y, String richtung, Schiff schiff){
        int count = 0;

        //Bevor ein Schiffe platziert wird, wird geprüft ob es innerhalb des Arrays ist und dass noch kein Schiff auf dem
        //Feld liegt.

        for (int i = 0; i < schiff.getLaenge(); i++) {
            if (richtung.equals("rechts") && ((x + i) >= 0 && (x + i) < spielfeld.length) && (y >= 0 && y < spielfeld.length) && (spielfeld[y][x + i].equals(Symbol.WASSER.getSymbol()))) {
                count++;
            } else if (richtung.equals("unten") && (x >= 0 && x < spielfeld.length) && ((y + i) >= 0 && (y + i) < spielfeld.length) && (spielfeld[y + i][x].equals(Symbol.WASSER.getSymbol()))) {
                count++;
            } else if (richtung.equals("links") && ((x - i) >= 0 && (x - i) < spielfeld.length) && (y >= 0 && y < spielfeld.length) && (spielfeld[y][x - i].equals(Symbol.WASSER.getSymbol()))) {
                count++;
            } else if (richtung.equals("oben") && (x >= 0 && x < spielfeld.length) && ((y - i) >= 0 && (y - i) < spielfeld.length) && (spielfeld[y - i][x].equals(Symbol.WASSER.getSymbol()))) {
                count++;
            }
        }

        return count == schiff.getLaenge();
    }

}
