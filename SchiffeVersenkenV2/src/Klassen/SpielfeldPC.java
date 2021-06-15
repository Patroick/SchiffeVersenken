package Klassen;

import Enum.Symbol;
import java.util.Random;

public class SpielfeldPC extends Spielfeld{
    public SpielfeldPC(int groesse, String spieler) {
        super(groesse, spieler);
    }

    public void platziereSchiffe(){
        String[] richtungen = {"rechts","unten","links","oben"};
        Random rand = new Random();
        for(Schiff schiff : schiffe){
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            String richtung = richtungen[rand.nextInt(4)];

            setzeSchiffe(x, y, richtung, schiff);
        }
    }

    public void anzeigenSpielfeld(){

        //Hier wird ober dem Spielfeld ein Koordinatensystem in der Konsole ausgegeben.
        System.out.println(" ");
        System.out.println(this.spieler);
        System.out.print("   ");
        for (int i = 1; i <= spielfeld.length; i++) {
            System.out.print(i + "  ");
        }
        System.out.println("→X");

        //Hier wird links neben dem Spielfeld ein Koordinatensystem und das Spielfeld ausgegeben.
        //Ausgabe des Koordinatensystems
        for (int i = 0; i < spielfeld.length; i++) {
            if(i < 9) {
                System.out.print(i + 1 + " |");
            } else{
                System.out.print(i + 1 + "|");
            }
            //Ausgabe des Spielfelds
            for (int j = 0; j < spielfeld[i].length; j++) {
                System.out.print(spielfeld[i][j] + "  ");
            }
            System.out.println("");

        }
        System.out.println("↓\nY");
    }
}
