package Klassen;

import Exceptions.InvalidIndexException;
import Exceptions.InvalidInputException;

import java.util.Locale;
import java.util.Scanner;

/**
 * Klasse für das KonsolenMenü
 */

public class KonsolenAusgabe {

    private Scanner sc = new Scanner(System.in);
    private Spieler currentSpieler;
    private Spieler gegner;

    /**
     * Konstruktor
     */
    public KonsolenAusgabe(){
    }

    /**
     * Methode mit der das Programm gestartet wird und der Spielablauf programmiert wurde
     */
    public void start(){
        System.out.println("Willkommen zu Schiffe Versenken!");
        try {
            auswahlModus();
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            start();
        }
        if(currentSpieler instanceof SpielerPC) {
            currentSpieler.platziereSchiffe();
        } else{
            currentSpieler.platziereSchiffe();
            playerSwitch();
        }
        gegner.platziereSchiffe();
        playerSwitch();
        while(!currentSpieler.pruefeGameOver()){
            if(currentSpieler instanceof SpielerPC){
                this.currentSpieler.angriff(gegner);
                Spieler temp = currentSpieler;
                currentSpieler = gegner;
                gegner = temp;
            } else {
                try {
                    this.angriffMenu();
                } catch (InvalidInputException e) {
                    System.out.println(e.getMessage());
                }
                playerSwitch();
                Spieler temp = currentSpieler;
                currentSpieler = gegner;
                gegner = temp;

            }
        }
        System.out.println(gegner.getSpielfeld().getName() + " hat gewonnen!");

    }

    /**
     * Methode um den Spielmodus auszuwählen
     *
     * @throws InvalidInputException
     */
    public void auswahlModus() throws InvalidInputException{
        System.out.println("Welchen Modus möchten Sie spielen? \n[1] 2 Spieler \n[2] PC");
        String modus = sc.nextLine().toLowerCase();
        if(modus.equals("1")){
            currentSpieler = new SpielerMensch(10, "Spieler 1");
            gegner = new SpielerMensch(10, "Spieler 2");
        } else if(modus.equals("2")){
            currentSpieler = new SpielerPC(10, "PC");
            gegner = new SpielerMensch(10, "Spieler");
        } else {
            throw new InvalidInputException();
        }

    }

    /**
     * Methode um das Angriffs Menü zu öffnen
     * @throws InvalidInputException
     */
    public void angriffMenu() throws InvalidInputException {
        System.out.println(currentSpieler.getSpielfeld().getName() + " ist am Zug");
        System.out.println("Was möchten Sie tun? \n[1] Angriff \n[2] Gegenerisches Feld anzeigen \n[3] Eigenes Feld anzeigen");
        String auswahl = sc.nextLine().toLowerCase();
        if(auswahl.equals("1")){
            currentSpieler.angriff(gegner);
        } else if(auswahl.equals("2")){
            gegner.spielfeld.anzeigenSpielfeld(gegner.spielfeld.getArraySpielfeldOhneSchiffe());
            angriffMenu();
        } else if(auswahl.equals("3")){
            currentSpieler.spielfeld.anzeigenSpielfeld(currentSpieler.spielfeld.getArraySpielfeld());
            angriffMenu();
        } else {
            throw new InvalidInputException();
        }
    }

    /**
     * Methode die einen Großen Leeraum in der Konsole erzeugt um einen Fairen Spielablauf im 2 Spieler Modus zu ermöglichen
     */
    public void playerSwitch(){
        System.out.println("Drücke Enter");
        sc.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
