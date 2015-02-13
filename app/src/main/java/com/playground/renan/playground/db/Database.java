package com.playground.renan.playground.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by renan on 2/13/15.
 */
public class Database extends SQLiteAssetHelper {

    public static final String DATABASE_SPEC = "playground.spec";
    public static final String DATABASE_NAME = "playground.db";
    public static final int DATABASE_VERSION = 1;


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
