package com.example.android_sql_example;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqlHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "products_db.db";
    private static final int DB_VERSION = 1;

    public static final String TABLE_PRODUCT = "products";
    public static final String COL_ID = "id";
    public static final String COL_TITLE = "title";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_PRICE = "price";

    public SqlHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABLE_PRODUCT+" (" +
                COL_ID+" integer primary key autoincrement,"+
                COL_TITLE+" text not null,"+
                COL_DESCRIPTION+" text not null,"+
                COL_PRICE+" real not null);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
