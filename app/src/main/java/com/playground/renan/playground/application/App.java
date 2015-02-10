package com.playground.renan.playground.application;

import android.app.Application;

import com.playground.renan.playground.entity.Cart;
import com.playground.renan.playground.entity.ItemCart;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by renan on 2/10/15.
 */
public class App extends Application {

    public Cart cart;

    @Override
    public void onCreate() {
        super.onCreate();

        init();

    }

    private void init() {
        cart = new Cart();
        cart.setItemCarts(new ArrayList<ItemCart>());
    }


}
