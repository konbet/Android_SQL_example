package com.example.android_sql_example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DataSource {

    String[] colums = {SqlHelper.COL_ID, SqlHelper.COL_TITLE, SqlHelper.COL_DESCRIPTION, SqlHelper.COL_PRICE};

    private SQLiteDatabase sqLiteDatabase;
    private SqlHelper sqlHelper;

    public DataSource(Context context){
        sqlHelper = new SqlHelper(context);
    }

    public void open(){
        sqLiteDatabase = sqlHelper.getWritableDatabase();
    }
    public void close(){
        sqLiteDatabase.close();
    }

    public void insertProduct(){
        this.open();
//        sqLiteDatabase.execSQL("INSERT INTO products (title, description, price) VALUES ('laptop', 'this is a laptop', 580.63)");
        ContentValues values = new ContentValues();
        values.put(SqlHelper.COL_TITLE, "TV");
        values.put(SqlHelper.COL_DESCRIPTION, "This is a TV");
        values.put(SqlHelper.COL_PRICE, 523.69);

        sqLiteDatabase.insert(SqlHelper.TABLE_PRODUCT, null, values);
        this.close();
    }

    public ArrayList<String> getAllProducts(){
        ArrayList<String> products = new ArrayList<>();
        this.open();
//        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM products", null);
        Cursor cursor = sqLiteDatabase.query(SqlHelper.TABLE_PRODUCT, colums, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            products.add(cursor.getString(1));
            Log.d("SQL_DATA", cursor.getString(1));
            cursor.moveToNext();
        }
        this.close();

        return products;
    }


}
