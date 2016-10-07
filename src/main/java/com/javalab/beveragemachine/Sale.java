package com.javalab.beveragemachine;

/**
 * @author Mariia Lapovska
 */
public class Sale {
    private Product product;
    private int payedCoins;

    public Sale(Product product, int payedCoins) {
        this.product = product;
        this.payedCoins = payedCoins;
    }

    public int returnChange() {
        return payedCoins - product.getPrice();
    }

    public Product getProduct() {
        return product;
    }
}
