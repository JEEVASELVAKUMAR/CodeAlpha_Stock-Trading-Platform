package stocktrading;

public class Transaction {
    private String stockSymbol;
    private int quantity;
    private String type;

    public Transaction(String stockSymbol, int quantity, String type) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.type = type;
    }

    public String toString() {
        return type + " " + stockSymbol + " Qty: " + quantity;
    }
}
