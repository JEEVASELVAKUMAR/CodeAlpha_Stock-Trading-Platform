package stocktrading;

import java.util.HashMap;
import java.util.ArrayList;

public class User {
    private double balance;
    private HashMap<String, Integer> portfolio;
    private ArrayList<Transaction> history;

    public User(double balance) {
        this.balance = balance;
        portfolio = new HashMap<>();
        history = new ArrayList<>();
    }

    public void buyStock(Stock stock, int qty) {
        double cost = stock.getPrice() * qty;

        if (cost <= balance) {
            balance -= cost;
            portfolio.put(stock.getSymbol(),
                    portfolio.getOrDefault(stock.getSymbol(), 0) + qty);
            history.add(new Transaction(stock.getSymbol(), qty, "BUY"));
            System.out.println("Stock bought successfully");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void sellStock(Stock stock, int qty) {
        int owned = portfolio.getOrDefault(stock.getSymbol(), 0);

        if (owned >= qty) {
            balance += stock.getPrice() * qty;
            portfolio.put(stock.getSymbol(), owned - qty);
            history.add(new Transaction(stock.getSymbol(), qty, "SELL"));
            System.out.println("Stock sold successfully");
        } else {
            System.out.println("Not enough stocks to sell");
        }
    }

    public void showPortfolio() {
        System.out.println("\n📊 Portfolio:");
        for (String key : portfolio.keySet()) {
            System.out.println(key + " → " + portfolio.get(key));
        }
        System.out.println("Balance: ₹" + balance);
    }
}
