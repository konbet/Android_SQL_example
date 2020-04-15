package com.example.android_sql_example;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DataSource {

    private SQLiteDatabase sqLiteDatabase;
    private SqlHelper sqlHelper;

    public DataSource(Context context){
        sqlHelper = new SqlHelper(context);
    }

    public void open(){
        sqLiteDatabase = sqlHelper.getWritableDatabase();
    }

    public void insertProduct(){
        this.open();
        sqLiteDatabase.execSQL("INSERT INTO products (title, description, price) VALUES ('laptop', 'this is a laptop', 580.63)");
    }

    public ArrayList<String> getAllProducts(){
        ArrayList<String> products = new ArrayList<>();
        this.open();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM products", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            products.add(cursor.getString(1));
            cursor.moveToNext();
        }

        return products;
    }


}
