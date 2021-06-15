package Klassen;

import Enum.Symbol;
import java.util.Scanner;

public class SpielfeldMensch extends Spielfeld{

    public SpielfeldMensch(int groesse, String spieler) {
        super(groesse, spieler);
    }

    public void platziereSchiffe(){
        Scanner sc = new Scanner(System.in);
        int i = 1;
        for(int n = 0; i <= schiffe.size();){
            System.out.println("Sie platzieren nun Ihr " + i + " Schiff mit der Länge " + schiffe.get(n).getLaenge() + ".");
            System.out.println("Geben Sie nun die gewünschte X Koordinate Ihres Schiffes ein: ");
            int x = sc.nextInt() - 1;
            System.out.println("Geben Sie nun die gewünschte Y Koordinate Ihres Schiffes ein: ");
            int y = sc.nextInt() - 1;
            System.out.println("Geben Sie die Richtung des Schiffes ein. [oben] [unten] [rechts] [links]");
            String richtung = sc.next();

            if(prüfeSpielfeld(x,y,richtung,schiffe.get(n))) {
                setzeSchiffe(x, y, richtung, schiffe.get(n));
                n++;
                i++;
            } else { //Exception
                continue;
            }
            anzeigenSpielfeld();
        }
    }

    public void anzeigenSpielfeld(){
        //Hier wird ober dem Spielfeld ein Koordinatensystem in der Konsole ausgegeben.
        System.out.println(" ");
        System.out.println(this.name);
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
