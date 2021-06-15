package Klassen;

public class Main{

    public static void main(String[] args){

        Spielfeld pc = new SpielfeldPC(10, "PC");
        pc.anzeigenSpielfeld();
        pc.platziereSchiffe();
        pc.anzeigenSpielfeld();

        Spielfeld spieler1 = new SpielfeldSpieler(10, "Spieler1");
        spieler1.anzeigenSpielfeld();
        spieler1.platziereSchiffe();
        spieler1.anzeigenSpielfeld();

    }

}
