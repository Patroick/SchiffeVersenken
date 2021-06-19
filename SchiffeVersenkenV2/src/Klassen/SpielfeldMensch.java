package Klassen;

public class SpielfeldMensch extends Spielfeld{

    public SpielfeldMensch(int groesse, String name) {
        super(groesse, name);
    }

    @Override
    void printSpielfeld(int x, int y) {
        System.out.print(arraySpielfeld[y][x].getSymbol() + "  ");
    }

}
