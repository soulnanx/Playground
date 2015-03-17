package com.playground.renan.playground.application;

import android.app.Application;

import com.codeslap.persistence.DatabaseSpec;
import com.codeslap.persistence.PersistenceConfig;
import com.playground.renan.playground.entity.Cart;
import com.playground.renan.playground.entity.ItemCart;
import com.playground.renan.playground.entity.Person;
import com.playground.renan.playground.db.Database;
import com.playground.renan.playground.entity.Product;
import com.playground.renan.playground.rest.GitHubService;
import com.playground.renan.playground.rest.Repo;
import com.playground.renan.playground.singleton.SingletonAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by renan on 2/10/15.
 */
public class App extends Application {

    public Cart cart;

    @Override
    public void onCreate() {
        super.onCreate();

        init();
        initDB();

    }


    private void initDB() {
        Database db = new Database(getApplicationContext());
        db.getWritableDatabase();

        DatabaseSpec database = PersistenceConfig.registerSpec(Database.DATABASE_SPEC, Database.DATABASE_VERSION);
        database.match(Person.class, Product.class);
        SingletonAdapter.getInstance(getApplicationContext());
    }

    private void init() {
        cart = new Cart();
        cart.setItemCarts(new ArrayList<ItemCart>());
    }


}
