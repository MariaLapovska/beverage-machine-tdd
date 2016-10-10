package com.javalab.beveragemachine;

import com.javalab.beveragemachine.core.BeverageMachine;
import com.javalab.beveragemachine.core.Product;
import com.javalab.beveragemachine.core.Sale;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mariia Lapovska
 */
public class Controller {

    private static final int COINS[] = {1, 5, 10, 25, 50};
    private static final Product PRODUCTS[] = {
            new Product("Tea", 25),
            new Product("Coffee", 35),
            new Product("Juice", 45)
    };
    private static final String MENU = "\nPress:\n" +
            "s - to select drink\n" +
            "i - to input coin\n" +
            "b - to check balance\n" +
            "q - to take back your money\n";

    private BeverageMachine beverageMachine;

    public Controller() {
        this.beverageMachine = new BeverageMachine(COINS, PRODUCTS);
    }

    public void processUser() {
        Product[] products = beverageMachine.allAssortment();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nDrinks in assortment:");

            for (Product product : products) {
                System.out.println(product);
            }

            System.out.print(MENU);

            String input = scanner.next();

            switch (input) {
                case "s" :
                    System.out.println("\nEnter drink name: ");

                    try {
                        Sale sale = beverageMachine.performSale(scanner.next());

                        System.out.println("\nTake your product: " + sale
                                .getProduct());
                        System.out.println("Take your change: " + sale
                                .returnChange());

                        return;
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;
                case "i" :
                    System.out.println("\nInput coin with value from list " +
                            "below:");
                    System.out.println(Arrays.toString(beverageMachine
                            .getCoinValues()));

                    if (beverageMachine.acceptCoin(scanIntegerValue(scanner))) {
                        System.out.println("\nCoin accepted. Your balance is:" +
                                " " + beverageMachine.getBalance());
                    } else {
                        System.out.println("\nCoin value is not supported!");
                    }

                    break;
                case "b" :
                    System.out.println("\nYour balance is: " + beverageMachine
                            .getBalance());
                    break;
                case "q" :
                    System.out.println("\nReturning input money: " +
                            beverageMachine.withdrawCoins());
                    return;
                default :
                    System.out.println("\nWrong command!");
            }
        }
    }

    private int scanIntegerValue(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Wrong input!");

            scanner.next();
        }

        return scanner.nextInt();
    }
}
