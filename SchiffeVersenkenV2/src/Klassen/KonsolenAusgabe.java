package Klassen;

import Exceptions.AlreadyHitException;

import java.util.Scanner;

public class KonsolenAusgabe {

    private final Scanner sc = new Scanner(System.in);

    public KonsolenAusgabe(){
    }

    public void angriff(Spieler spieler, Spieler gegner){
        System.out.println(spieler.getSpielfeld().getName() + " ist am Zug!");
        System.out.println("Geben Sie die X Koordinate ein auf die Sie feuern wollen: ");
        int x = sc.nextInt() - 1;
        System.out.println("Geben Sie die Y Koordinate ein auf die Sie feuern wollen: ");
        int y = sc.nextInt() - 1;

        try {
            if(spieler.getSpielfeld().pruefeSpielfeld(x, y)){
                spieler.angriff(gegner, x, y);
            }
        } catch (AlreadyHitException e) {
            System.out.println(e.getMessage());
            angriff(spieler, gegner);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Die eingegeben Koordinaten liegen ausherhalb des Spielfelds");
            angriff(spieler, gegner);
        }
    }
}
