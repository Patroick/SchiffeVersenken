package Klassen;

abstract class Spieler {

    protected Spielfeld spielfeld;

    public Spieler(){
    }

    abstract void platziereSchiffe();
    abstract void angriff(Spieler gegner, int x, int y);
    public boolean pruefeGameOver(){
        if(this.spielfeld.getSchiffe().isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public Spielfeld getSpielfeld() {
        return spielfeld;
    }

    public void setSpielfeld(Spielfeld spielfeld) {
        this.spielfeld = spielfeld;
    }
}
