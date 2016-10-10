package com.javalab.beveragemachine.core;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Mariia Lapovska
 */
public class BeverageMachine {
    private int[] coinValues;
    private Product[] assortment;
    private int balance = 0;

    public BeverageMachine(int[] coinValues, Product[] assortment) {
        this.coinValues = coinValues;
        this.assortment = assortment;
    }

    public int[] getCoinValues() {
        return coinValues;
    }

    public boolean acceptCoin(int value) {
        for (int coinValue : coinValues) {
            if (coinValue == value) {
                balance += value;
                return true;
            }
        }

        return false;
    }

    public Product[] allAssortment() {
        return assortment;
    }

    public Sale performSale(String productName) {
        Product selectedProduct = getProduct(productName);

        if (selectedProduct == null) {
            throw new IllegalArgumentException("Product doesn't exist!");
        }
        if (selectedProduct.getPrice() > balance) {
            throw new RuntimeException("Not enough money for purchase!");
        }

        return new Sale(selectedProduct, withdrawCoins());
    }

    public int withdrawCoins() {
        int temp = balance;
        balance = 0;

        return temp;
    }

    public int getBalance() {
        return balance;
    }

    private Product getProduct(String productName) {
        for (Product product : assortment) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }

        return null;
    }
}