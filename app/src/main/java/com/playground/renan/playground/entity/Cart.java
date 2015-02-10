package com.playground.renan.playground.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by renan on 2/10/15.
 */
public class Cart {
    private List<ItemCart> itemCarts;

    public void addItemOnCart(ItemCart itemCart){
        if (itemCarts.contains(itemCart)){
            for (ItemCart itemCartAlreadyInCart : itemCarts){
                if (itemCartAlreadyInCart.equals(itemCart)){
                    itemCartAlreadyInCart.addQuantity();

                }
            }
        } else {
            itemCart.addQuantity();
            itemCarts.add(itemCart);
        }
    }

    public void removeItemOnCart(ItemCart itemCart){

        if (itemCarts.contains(itemCart)){
            for (ItemCart itemCartAlreadyInCart : itemCarts){
                if (itemCartAlreadyInCart.equals(itemCart)){
                    itemCartAlreadyInCart.removeQuantity();
                    if (itemCartAlreadyInCart.getQuantity() == 0){
                        itemCarts.remove(itemCartAlreadyInCart);
                        break;
                    }
                }
            }
        }
    }

    public BigDecimal getTotalCartValue(){
        BigDecimal cartTotalValue = BigDecimal.ZERO;

        for (ItemCart itemCart : itemCarts){
            cartTotalValue = cartTotalValue.add(itemCart.getTotalValue());
        }
        return cartTotalValue;
    }

    public List<ItemCart> getItemCarts() {
        return itemCarts;
    }

    public void setItemCarts(List<ItemCart> itemCarts) {
        this.itemCarts = itemCarts;
    }
}
