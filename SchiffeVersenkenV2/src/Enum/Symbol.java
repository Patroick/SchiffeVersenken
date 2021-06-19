package Enum;

public enum Symbol {

    WASSER("\u001B[36m" + "~" + "\u001B[0m"), SCHIFF("\u001B[30m" + "#" + "\u001B[0m"),
    SCHUSS("\u001B[32m" + "P" + "\u001B[0m"), TREFFER("\u001B[31m" + "X" + "\u001B[0m");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol(){
        return symbol;
    }

}
