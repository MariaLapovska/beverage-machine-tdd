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
    public void canDeclineCoin() {
        assertEquals(false, beverageMachine.acceptCoin(7));
    }

    @Test
    public void canSelectExistingProduct() {
        assertEquals(new Product("Coffee", 35), beverageMachine.selectProduct
                ("Coffee"));
    }

    @Test
    public void returnsNullIfProductNotExists() {
        assertNull(beverageMachine.selectProduct("Ice tea"));
    }

    @Test
    public void canReturnCoins() {
        beverageMachine.acceptCoin(10);
        beverageMachine.acceptCoin(5);
        beverageMachine.acceptCoin(5);
        assertEquals(20, beverageMachine.returnInputCoins());
    }

    @Test
    public void emptiesBalanceAfterCoinsReturn() {
        beverageMachine.acceptCoin(10);
        beverageMachine.acceptCoin(5);
        beverageMachine.acceptCoin(5);
        beverageMachine.returnInputCoins();
        assertEquals(0, beverageMachine.getBalance());
    }
}