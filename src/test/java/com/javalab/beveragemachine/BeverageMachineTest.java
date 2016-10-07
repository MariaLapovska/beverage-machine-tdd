package com.javalab.beveragemachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mariia Lapovska
 */
public class BeverageMachineTest {
    private final int[] coinValues = new int[] {1, 5, 10, 25, 50};

    private BeverageMachine beverageMachine;

    @Before
    public void setUp() {
        beverageMachine = new BeverageMachine(coinValues);
    }

    @Test
    public void canAcceptCoin() {
        assertEquals(true, beverageMachine.acceptCoin(10));
    }

    @Test
    public void canDeclineCoin() {
        assertEquals(false, beverageMachine.acceptCoin(7));
    }
}
