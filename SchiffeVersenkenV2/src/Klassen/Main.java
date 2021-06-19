package Klassen;

public class Main{

    public static void main(String[] args){

        Spieler pc = new SpielerPC(10, "PC");
        pc.spielfeld.anzeigenSpielfeld();
        pc.platziereSchiffe();
        pc.spielfeld.anzeigenSpielfeld();

        Spieler spieler = new SpielerMensch(10, "Spieler");
        spieler.spielfeld.anzeigenSpielfeld();
        spieler.platziereSchiffe();
        spieler.spielfeld.anzeigenSpielfeld();
    }

}
