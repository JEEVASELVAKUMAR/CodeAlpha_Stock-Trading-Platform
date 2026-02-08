package stocktrading;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stock apple = new Stock("AAPL", 150);
        Stock google = new Stock("GOOG", 2800);

        User user = new User(10000);

        while (true) {
            System.out.println("\n1. Buy Apple");
            System.out.println("2. Sell Apple");
            System.out.println("3. View Portfolio");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                user.buyStock(apple, 1);
            } else if (choice == 2) {
                user.sellStock(apple, 1);
            } else if (choice == 3) {
                user.showPortfolio();
            } else {
                break;
            }
        }

        sc.close();
    }
}
