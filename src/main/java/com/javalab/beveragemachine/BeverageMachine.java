package com.javalab.beveragemachine;

/**
 * @author Mariia Lapovska
 */
public class BeverageMachine {
    private int[] coinValues;

    public BeverageMachine(int[] coinValues) {
        this.coinValues = coinValues;
    }

    public boolean acceptCoin(int value) {
        for (int coinValue : coinValues) {
            if (coinValue == value) {
                return true;
            }
        }

        return false;
    }
}
