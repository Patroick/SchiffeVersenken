package Klassen;

import Enum.Symbol;

import java.util.Arrays;
import java.util.Random;

public class SpielfeldPC extends Spielfeld{

    private String[][] spielfeldOhneSchiffe;

    public SpielfeldPC(int groesse, String spieler) {
        super(groesse, spieler);
        /*spielfeldOhneSchiffe = new String[groesse][groesse];
        for (int i = 0; i < spielfeldOhneSchiffe.length; i++) {
            for (int j = 0; j < spielfeldOhneSchiffe[i].length; j++) {
                spielfeldOhneSchiffe[i][j] = Symbol.WASSER.getSymbol();
            }
        }
        */
        spielfeldOhneSchiffe = spielfeld;
    }

    public void anzeigenSpielfeld(){

        //Hier wird ober dem Spielfeld ein Koordinatensystem in der Konsole ausgegeben.
        System.out.println(" ");
        System.out.println(this.name);
        System.out.print("   ");
        for (int i = 1; i <= spielfeldOhneSchiffe.length; i++) {
            System.out.print(i + "  ");
        }
        System.out.println("→X");

        //Hier wird links neben dem Spielfeld ein Koordinatensystem und das Spielfeld ausgegeben.
        //Ausgabe des Koordinatensystems
        for (int i = 0; i < spielfeldOhneSchiffe.length; i++) {
            if(i < 9) {
                System.out.print(i + 1 + " |");
            } else{
                System.out.print(i + 1 + "|");
            }
            //Ausgabe des Spielfelds
            for (int j = 0; j < spielfeldOhneSchiffe[i].length; j++) {
                System.out.print(spielfeldOhneSchiffe[i][j] + "  ");
            }
            System.out.println("");

        }
        System.out.println("↓\nY");
    }
}
