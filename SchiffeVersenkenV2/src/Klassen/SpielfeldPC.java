package Klassen;

import Enum.Symbol;

public class SpielfeldPC extends Spielfeld{

    private final Symbol[][] arraySpielfeldOhneSchiffe;

    public SpielfeldPC(int groesse, String name) {
        super(groesse, name);
        /*spielfeldOhneSchiffe = new Symbol[groesse][groesse];
        for (int i = 0; i < spielfeldOhneSchiffe.length; i++) {
            Arrays.fill(spielfeldOhneSchiffe[i], Symbol.WASSER);
        }
        */
        arraySpielfeldOhneSchiffe = arraySpielfeld;
    }

    @Override
    void printSpielfeld(int x, int y) {
        System.out.print(arraySpielfeldOhneSchiffe[y][x].getSymbol() + "  ");
    }
}
