package com.example.android_sql_example;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqlHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "products_db.db";
    private static final int DB_VERSION = 1;

    public SqlHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE products (" +
                "id integer primary key autoincrement,"+
                "title text not null,"+
                "description text not null,"+
                "price real not null);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
