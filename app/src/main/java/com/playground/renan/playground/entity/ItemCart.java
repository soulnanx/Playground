package com.playground.renan.playground.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by renan on 2/10/15.
 */
public class ItemCart {

    private Product product;
    private int quantity;

    public ItemCart() {
    }

    public ItemCart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void addQuantity(){
        this.quantity = this.quantity +1;
    }

    public void removeQuantity(){
        if (this.quantity > 0){
            this.quantity = this.quantity -1;
        }
    }



    public static List<ItemCart> getFakeList(){
        List<ItemCart> itemCarts = new ArrayList<>();

        itemCarts.add(new ItemCart(new Product("Coffee", new BigDecimal(2.50), "High quality coffee"), 0));
        itemCarts.add(new ItemCart(new Product("Sugar", new BigDecimal(3.20), "the most shipper sugar"), 0));
        itemCarts.add(new ItemCart(new Product("Milk", new BigDecimal(1.50), "the fresh milk"),0));
        itemCarts.add(new ItemCart(new Product("Chocolate", new BigDecimal(0.50), "chocolate without sugar"),0));

        return itemCarts;
    }


    public BigDecimal getTotalValue(){
        return product.getValue().multiply(new BigDecimal(quantity));
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemCart)) return false;

        ItemCart itemCart = (ItemCart) o;

        if (product != null ? !product.equals(itemCart.product) : itemCart.product != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return product != null ? product.hashCode() : 0;
    }
}
