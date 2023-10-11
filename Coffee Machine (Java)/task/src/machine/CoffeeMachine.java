package machine;

import java.util.Objects;
import java.util.Scanner;

public class CoffeeMachine {
    int waterAmt = 400;
    int milkAmt = 540;
    int coffeeBeansAmt = 120;
    int cups = 9;
    int money = 550;

    public void prompt() {
        boolean isExit = false;
        while(!isExit) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            if (Objects.equals(action, Action.BUY.name().toLowerCase())) {
                System.out.println();
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                action = scanner.next();
                buy(action);
            }
            if (Objects.equals(action, Action.FILL.name().toLowerCase())) {
                System.out.println();
                System.out.println("Write how many ml of water you want to add:");
                int waterAmount = scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                int milkAmount = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add:");
                int coffeeBeansAmount = scanner.nextInt();
                System.out.println("Write how many disposable cups you want to add:");
                int cupsNeeded = scanner.nextInt();
                fill(waterAmount, milkAmount, coffeeBeansAmount, cupsNeeded);
            }
            if (Objects.equals(action, Action.TAKE.name().toLowerCase())) {
                take(money);
            }
            if (Objects.equals(action, Action.REMAINING.name().toLowerCase())) {
                remaining(waterAmt, milkAmt, coffeeBeansAmt, cups, money);
            }
            if (Objects.equals(action, Action.EXIT.name().toLowerCase())) {
                isExit = true;
            }
        }
    }
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.prompt();
    }
    public void buy(String action) {
        switch (action) {
            case "1":
                if (waterAmt >= 250 && coffeeBeansAmt >= 16) {
                    System.out.println("I have enough resources, making you a coffee!");
                    System.out.println();
                    this.waterAmt = waterAmt - 250;
                    this.coffeeBeansAmt = coffeeBeansAmt - 16;
                    this.cups--;
                    this.money = money + 4;
                } else {
                    System.out.println("Sorry, not enough " + ((waterAmt >= 250)?"coffee":"water" ) + "!");
                    System.out.println();
                }
                break;
            case "2":
                if (waterAmt >= 350 && milkAmt >= 75 && coffeeBeansAmt >= 20) {
                    System.out.println("I have enough resources, making you a coffee!");
                    System.out.println();
                    this.waterAmt = waterAmt - 350;
                    this.milkAmt = milkAmt - 75;
                    this.coffeeBeansAmt = coffeeBeansAmt - 20;
                    this.cups--;
                    this.money = money + 7;
                } else {
                    System.out.println("Sorry, not enough " + ((waterAmt >= 350 && milkAmt >= 75)?"coffee":(coffeeBeansAmt >= 20 && milkAmt >= 75)?"water":"milk" ) + "!");
                    System.out.println();
                }
                break;
            case "3":
                if (waterAmt >= 200 && milkAmt >= 100 && coffeeBeansAmt >= 12) {
                    System.out.println("I have enough resources, making you a coffee!");
                    System.out.println();
                    this.waterAmt = waterAmt - 200;
                    this.milkAmt = milkAmt - 100;
                    this.coffeeBeansAmt = coffeeBeansAmt - 12;
                    this.cups--;
                    this.money = money + 6;
                } else {
                    System.out.println("Sorry, not enough " + ((waterAmt >= 200 && milkAmt >= 100)?"coffee":(coffeeBeansAmt >= 12 && milkAmt >= 100)?"water":"milk" ) + "!");
                    System.out.println();
                }
                break;
            default:
                break;
        }
    }
    public void fill(int waterAmount, int milkAmount, int coffeeBeansAmount, int cupsNeeded) {
        this.waterAmt = waterAmt + waterAmount;
        this.milkAmt = milkAmt + milkAmount;
        this.coffeeBeansAmt = coffeeBeansAmt + coffeeBeansAmount;
        this.cups = cups + cupsNeeded;
        System.out.println();
    }
    public void take(int money) {
        System.out.println("I gave you $" + money);
        this.money = 0;
        System.out.println();
    }
    public void remaining(int waterAmt, int milkAmt, int coffeeBeansAmt, int cups, int money) {
        System.out.println();
        printResult(waterAmt, milkAmt, coffeeBeansAmt, cups, money);
    }
    public static void printResult(int waterAmt, int milkAmt, int coffeeBeansAmt, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(waterAmt + " ml of water");
        System.out.println(milkAmt + " ml of milk");
        System.out.println(coffeeBeansAmt + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();
    }
}
