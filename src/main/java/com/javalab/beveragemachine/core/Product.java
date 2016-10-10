package com.javalab.beveragemachine.core;

/**
 * @author Mariia Lapovska
 */
public class Product {

    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + price;

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }

        Product product = (Product) o;

        return product.name.equals(name) && product.price == price;
    }

    @Override
    public String toString() {
        return name + ", price: " + price;
    }
}
