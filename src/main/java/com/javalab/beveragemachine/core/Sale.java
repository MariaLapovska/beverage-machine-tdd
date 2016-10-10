package com.javalab.beveragemachine.core;

/**
 * @author Mariia Lapovska
 */
public class Sale {
    private Product product;
    private int payment;

    public Sale(Product product, int payment) {
        this.product = product;
        this.payment = payment;
    }

    public int returnChange() {
        return payment - product.getPrice();
    }

    public Product getProduct() {
        return product;
    }
}