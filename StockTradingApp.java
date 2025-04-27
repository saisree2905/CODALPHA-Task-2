import java.util.*;

class Stock {
    String symbol;
    String name;
    double price;

    public Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }
}

class PortfolioItem {
    Stock stock;
    int quantity;
    double averageBuyPrice;

    public PortfolioItem(Stock stock, int quantity, double averageBuyPrice) {
        this.stock = stock;
        this.quantity = quantity;
        this.averageBuyPrice = averageBuyPrice;
    }
}

class User {
    String username;
    double cashBalance;
    Map<String, PortfolioItem> portfolio;

    public User(String username, double cashBalance) {
        this.username = username;
        this.cashBalance = cashBalance;
        this.portfolio = new HashMap<>();
    }

    public void buyStock(Stock stock, int quantity) {
        double totalCost = stock.price * quantity;
        if (cashBalance >= totalCost) {
            cashBalance -= totalCost;
            PortfolioItem item = portfolio.get(stock.symbol);
            if (item == null) {
                portfolio.put(stock.symbol, new PortfolioItem(stock, quantity, stock.price));
            } else {
                int newQuantity = item.quantity + quantity;
                double newAvgPrice = ((item.averageBuyPrice * item.quantity) + (stock.price * quantity)) / newQuantity;
                item.quantity = newQuantity;
                item.averageBuyPrice = newAvgPrice;
            }
            System.out.println("Bought " + quantity + " shares of " + stock.symbol);
        } else {
            System.out.println("Not enough balance!");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        PortfolioItem item = portfolio.get(stock.symbol);
        if (item != null && item.quantity >= quantity) {
            double totalRevenue = stock.price * quantity;
            cashBalance += totalRevenue;
            item.quantity -= quantity;
            if (item.quantity == 0) {
                portfolio.remove(stock.symbol);
            }
            System.out.println("Sold " + quantity + " shares of " + stock.symbol);
        } else {
            System.out.println("Not enough shares to sell!");
        }
    }

    public void showPortfolio() {
        System.out.println("\n--- Portfolio ---");
        for (PortfolioItem item : portfolio.values()) {
            double currentValue = item.stock.price * item.quantity;
            double profitLoss = currentValue - (item.averageBuyPrice * item.quantity);
            System.out.printf("%s | Shares: %d | Avg Buy: %.2f | Current Price: %.2f | P/L: %.2f\n",
                    item.stock.symbol, item.quantity, item.averageBuyPrice, item.stock.price, profitLoss);
        }
        System.out.printf("Cash Balance: %.2f\n", cashBalance);
    }
}

public class StockTradingApp {
    static Map<String, Stock> stockMarket = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User("demo_user", 10000.0);

        // Initialize some stocks
        stockMarket.put("AAPL", new Stock("AAPL", "Apple Inc.", 150.0));
        stockMarket.put("GOOGL", new Stock("GOOGL", "Alphabet Inc.", 2800.0));
        stockMarket.put("TSLA", new Stock("TSLA", "Tesla Inc.", 700.0));
        stockMarket.put("AMZN", new Stock("AMZN", "Amazon.com Inc.", 3400.0));

        System.out.println("==============================================================");
        System.out.println("|              JAVA STOCK TRADING STIMULATOR                 |");
        System.out.println("|                POWERED BY CONSOLE MARKET                   |");
        System.out.println("|                   |  BY M SAISREE  |                       |");
        System.out.println("==============================================================\n");

        while (true) {
            System.out.println("\n--- Stock Trading Platform ---");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                viewMarket();
            } else if (choice == 2) {
                System.out.print("Enter stock symbol to buy: ");
                String symbol = scanner.next().toUpperCase();
                System.out.print("Enter quantity: ");
                int qty = scanner.nextInt();
                Stock stock = stockMarket.get(symbol);
                if (stock != null) {
                    user.buyStock(stock, qty);
                } else {
                    System.out.println("Stock not found!");
                }
            } else if (choice == 3) {
                System.out.print("Enter stock symbol to sell: ");
                String symbol = scanner.next().toUpperCase();
                System.out.print("Enter quantity: ");
                int qty = scanner.nextInt();
                Stock stock = stockMarket.get(symbol);
                if (stock != null) {
                    user.sellStock(stock, qty);
                } else {
                    System.out.println("Stock not found!");
                }
            } else if (choice == 4) {
                user.showPortfolio();
            } else if (choice == 5) {
                System.out.println("Exiting... Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Try again!");
            }
        }
    }

    public static void viewMarket() {
        System.out.println("\n--- Market Prices ---");
        for (Stock stock : stockMarket.values()) {
            System.out.printf("%s (%s): $%.2f\n", stock.name, stock.symbol, stock.price);
        }
    }
}
