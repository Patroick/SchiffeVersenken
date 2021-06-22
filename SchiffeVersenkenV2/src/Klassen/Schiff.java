package Klassen;

/**
 * Schiff Klasse in der die Länge der gegebenen Schiffe gespeichert wird
 */

public class Schiff {

    private int laenge;

    /**
     * Konstruktor dem die Länge als Parameter mitgegeben wird
     *
     * @param laenge
     */

    public Schiff(int laenge){
        this.laenge = laenge;
    }

    /**
     * Getter für Länge
     *
     * @return
     */

    public int getLaenge(){
        return laenge;
    }

    /**
     * Setter für Länge
     *
     * @param laenge
     */

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

}
