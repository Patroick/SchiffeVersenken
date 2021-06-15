package Klassen;

import java.util.Scanner;

public class SpielerMensch extends Spieler{

    public SpielerMensch(int groesse, String name) {
        spielfeld = new SpielfeldMensch(groesse, name);
    }

    public void platziereSchiffe(){
        Scanner sc = new Scanner(System.in);
        int i = 1;
        for(int n = 0; i <= spielfeld.getSchiffe().size();){
            System.out.println("Sie platzieren nun Ihr " + i + " Schiff mit der Länge " + spielfeld.getSchiffe().get(n).getLaenge() + ".");
            System.out.println("Geben Sie nun die gewünschte X Koordinate Ihres Schiffes ein: ");
            int x = sc.nextInt() - 1;
            System.out.println("Geben Sie nun die gewünschte Y Koordinate Ihres Schiffes ein: ");
            int y = sc.nextInt() - 1;
            System.out.println("Geben Sie die Richtung des Schiffes ein. [oben] [unten] [rechts] [links]");
            String richtung = sc.next();

            if(spielfeld.prüfeSpielfeld(x,y,richtung,spielfeld.getSchiffe().get(n))) {
                spielfeld.setzeSchiffe(x, y, richtung, spielfeld.getSchiffe().get(n));
                n++;
                i++;
            } else { //Exception
                continue;
            }
            spielfeld.anzeigenSpielfeld();
        }
    }

    public void angriff(Spieler gegner){

        Scanner sc = new Scanner(System.in);
        int x;
        int y;
        System.out.println("\n" + .getName() + " greift an.");


        for (int i = 0; i < spieler1.getSchuesseProZug(); ) {

            //Einlesen der Koordinaten

            System.out.println("Sie haben " + i + " von " + spieler1.getSchuesseProZug() + " Schüsse verwendet.");
            System.out.println("Geben Sie die X Koordinate ein auf die Sie feuern wollen: ");
            //Die Eingabe wird um 1 verringert da der Index des Arrays bei 0 startet.
            x = sc.nextInt() - 1;
            System.out.println("Geben Sie die Y Koordinate ein auf die Sie feuern wollen: ");
            y = sc.nextInt() - 1;

            //Hier wird geprüft ob die eingegeben Koordinaten innerhalb des Spielfelds liegen.

            if(x < spieler2.getArr1().length && y < spieler2.getArr1().length) {

                //Hier wird geprüft ob das Feld noch nicht beschossen wurde.
                if ((spieler2.getArr1()[y][x].equals(SpielFeld.symbolSchiff) || spieler2.getArr1()[y][x].equals(SpielFeld.symbolWasser)) &&
                        (!spieler2.getArr1()[y][x].equals(SpielFeld.symbolTreffer) || !spieler2.getArr1()[y][x].equals(SpielFeld.symbolSchuss))) {
                    //Wenn das Feld ein Schiff ist das Schiff durch ein Treffer Symbol ersetzt.
                    if (spieler2.getArr1()[y][x].equals(SpielFeld.symbolSchiff)) {
                        spieler2.setArr1(y, x, SpielFeld.symbolTreffer);
                        spieler2.setArr2(y, x, SpielFeld.symbolTreffer);
                    }
                    //Wenn das Feld kein Schiff ist das Feld durch ein Schuss Symbol ersetzt.
                    else {
                        spieler2.setArr1(y, x, SpielFeld.symbolSchuss);
                        spieler2.setArr2(y, x, SpielFeld.symbolSchuss);
                    }
                    i++;
                    //Spielfeld wird auf der Konsole ausgegeben.
                    anzeigenSpielfeld();
                } else if (spieler2.getArr1()[y][x].equals(SpielFeld.symbolTreffer) || spieler2.getArr1()[y][x].equals(SpielFeld.symbolSchuss)) {
                    System.out.println("Sie haben dieses Feld bereits beschossen!");
                } else {
                    System.out.println("Bitte geben Sie eine gültige Koordinate ein!");
                }
                //Hier wird geprüft ob der Spieler gewonnen hat.
                spieler2.pruefeGameOver();
                if (spieler2.isGameOver()) {
                    gewinner = spieler1.getName();
                    System.out.println(gewinner + " hat das Spiel gewonnen!");
                    break;
                }
            }
        }

    }
}
