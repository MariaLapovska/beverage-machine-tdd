package com.javalab.beveragemachine;

/**
 * @author Mariia Lapovska
 */
public class BeverageMachine {
    private int[] coinValues;
    private Product[] assortment;

    public BeverageMachine(int[] coinValues, Product[] assortment) {
        this.coinValues = coinValues;
        this.assortment = assortment;
    }

    public boolean acceptCoin(int value) {
        for (int coinValue : coinValues) {
            if (coinValue == value) {
                return true;
            }
        }

        return false;
    }

    public Product selectProduct(String productName) {
        for (Product product : assortment) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }

        return null;
    }
}