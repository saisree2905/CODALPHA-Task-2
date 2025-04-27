# CodeAlpha_Project_StockTradingPlatform
NAME:M.SAISREE

STUDENTID:CA/AP1/3057

COMPANY:CODEALPHA

DOMAIN:JAVA PROGRAMMING

DURATION:APRIL TO MAY 2025

**OVERVIEW OF THE PROJECT**

PROJECT NAME: STOCKTRADINGPLATFORM
This is a console-based Java application that allows users to simulate buying and selling stocks with virtual cash. Users can view live market prices (static for now), manage their portfolio, and track profit/loss on their investments.

**Features**

->View available stocks and their current prices.

->Buy stocks using virtual cash balance.

->Sell stocks from the owned portfolio.

->Track detailed portfolio performance:

1)Number of shares owned

2)Average buying price

3)Current market price

4)Profit/Loss per stock

->User-friendly console menu.

 **Technologies Used**
 
->Java SE (Standard Edition)

->HashMap and OOP concepts (Classes, Objects, Encapsulation)

->Console-based I/O using Scanner

->Formatted Output using System.out.printf()

**Project Structure**

->Stock.java - Represents a stock entity with symbol, name, and current price.

->PortfolioItem.java - Represents a user's investment in a particular stock.

->User.java - Manages the user's portfolio, buying/selling actions, and cash balance.

->StockTradingApp.java - Main application file. Handles user interaction, displays menus, and controls the flow of the app.





Sample Demo

==============================================================

|                  JAVA STOCK TRADING SIMULATOR                     |

|                  POWERED BY CONSOLE MARKET                          |

|                      |  BY M SAISREE  |                            |

==============================================================


--- Stock Trading Platform ---

1. View Market
 
2. Buy Stock
 
3. Sell Stock

4. View Portfolio

5. Exit
   
Choose an option:

 
 **Future Improvements (Optional)**
 
->Simulate real-time stock price updates.

->Add input validation for safer user interaction.

->Allow saving and loading the portfolio from a file.

->Improve financial accuracy using BigDecimal instead of double.

->Add overall portfolio performance summary.
**OVERVIEW OF THE CODE**

1.**Stock Class**

->Represents a stock available in the market.

->Contains:

*symbol (e.g., "AAPL" for Apple)

*name (full company name)

*price (current market price per share)

2. **PortfolioItem Class**
 
->Represents a stock owned by the user.

->Tracks:

*The stock object itself.

*quantity (number of shares owned).

*averageBuyPrice (the average price at which shares were bought).

3.**User Class**

->Represents the user playing the simulator.

->Manages:

*username

*cashBalance (virtual cash available for trading)

*portfolio (a map of stock symbols to PortfolioItems).

->Provides functionality to:

*Buy stocks (update cash balance and portfolio).

*Sell stocks (increase cash balance and update holdings).

*Display the current portfolio with profit/loss calculations.

4. **StockTradingApp Class**

->The main class that contains the main method.

->Initializes the stock market with predefined stocks.

->Displays a console menu for user interaction:

*View Market Prices

*Buy Stocks

*Sell Stocks

*View Portfolio

*Exit the application

->Handles user inputs using a Scanner.

**Key Concepts Demonstrated**

->Object-Oriented Programming (OOP):

*Classes and Objects

*Encapsulation

->Data Structures:

*HashMap to store the user's portfolio and market stocks.

->Basic Financial Calculations:

*Total cost of purchase

*Average buying price adjustment

*Profit/Loss calculation based on current market price

->Console Input/Output:

*Reading user inputs

Displaying neatly formatted outputs using System.out.printf()

![Screenshot 2025-04-28 005708](https://github.com/user-attachments/assets/46744fee-740a-44d1-8915-88d464084829)


