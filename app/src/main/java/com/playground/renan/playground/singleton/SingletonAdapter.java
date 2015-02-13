package com.playground.renan.playground.singleton;

import android.content.Context;

import com.codeslap.persistence.Persistence;
import com.codeslap.persistence.SqlAdapter;
import com.playground.renan.playground.db.Database;

/**
 * Created by renan on 2/13/15.
 */
public class SingletonAdapter {

    private static SingletonAdapter singletonAdapter;
    private static SqlAdapter adapter;

    private SingletonAdapter(Context context){
        adapter = Persistence.getAdapter(context, Database.DATABASE_NAME, Database.DATABASE_SPEC);
    }

    public static SingletonAdapter getInstance(Context context){

        if (singletonAdapter == null){
            singletonAdapter = new SingletonAdapter(context);
        }

        return singletonAdapter;

    }

    public static SingletonAdapter getInstance(){
        return getInstance(null);
    }

    public SqlAdapter getAdapter() {
        return adapter;
    }
}
