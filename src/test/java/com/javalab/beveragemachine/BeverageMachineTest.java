package com.javalab.beveragemachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Mariia Lapovska
 */
public class BeverageMachineTest {
    private final int[] coinValues = new int[]{1, 5, 10, 25, 50};
    private final Product[] assortment = new Product[]{new Product("Tea", 25),
            new Product("Coffee", 35),
            new Product("Juice", 45)};

    private BeverageMachine beverageMachine;

    @Before
    public void setUp() {
        beverageMachine = new BeverageMachine(coinValues, assortment);
    }

    @Test
    public void canAcceptCoin() {
        assertEquals(true, beverageMachine.acceptCoin(10));
    }

    @Test
    public void canDeclineCoinIfValueIsNotSupported() {
        assertEquals(false, beverageMachine.acceptCoin(7));
    }

    @Test
    public void canReturnCoins() {
        beverageMachine.acceptCoin(10);
        beverageMachine.acceptCoin(5);
        beverageMachine.acceptCoin(5);
        assertEquals(20, beverageMachine.withdrawCoins());
    }

    @Test
    public void emptiesBalanceAfterCoinsReturn() {
        beverageMachine.acceptCoin(10);
        beverageMachine.acceptCoin(5);
        beverageMachine.acceptCoin(5);
        beverageMachine.withdrawCoins();
        assertEquals(0, beverageMachine.getBalance());
    }

    @Test
    public void canReturnProductAndChange() {
        beverageMachine.acceptCoin(10);
        beverageMachine.acceptCoin(50);
        beverageMachine.acceptCoin(5);

        Sale sale = beverageMachine.performSale("Tea");

        assertEquals(40, sale.returnChange());
        assertEquals(new Product("Tea", 25), sale.getProduct());
    }

    @Test
    public void emptiesBalanceAfterSale() {
        beverageMachine.acceptCoin(10);
        beverageMachine.acceptCoin(50);
        beverageMachine.acceptCoin(5);
        beverageMachine.performSale("Tea");
        assertEquals(0, beverageMachine.getBalance());
    }

    @Test(expected=IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionIfProductNotExist() {
        beverageMachine.performSale("Ice tea");
    }

    @Test(expected=RuntimeException.class)
    public void throwsRuntimeExceptionIfNotEnoughMoney() {
        beverageMachine.performSale("Tea");
    }

    @Test
    public void canPerformFewSalesInARow() {
        beverageMachine.acceptCoin(50);

        Sale sale = beverageMachine.performSale("Tea");
        assertEquals(25, sale.returnChange());
        assertEquals(new Product("Tea", 25), sale.getProduct());

        beverageMachine.acceptCoin(10);
        beverageMachine.acceptCoin(50);

        sale = beverageMachine.performSale("Coffee");
        assertEquals(25, sale.returnChange());
        assertEquals(new Product("Coffee", 35), sale.getProduct());

        beverageMachine.acceptCoin(10);
        beverageMachine.acceptCoin(25);
        beverageMachine.acceptCoin(10);

        sale = beverageMachine.performSale("Juice");
        assertEquals(0, sale.returnChange());
        assertEquals(new Product("Juice", 45), sale.getProduct());
    }
}