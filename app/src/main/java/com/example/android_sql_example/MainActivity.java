package com.example.android_sql_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataSource dataSource = new DataSource(MainActivity.this);

        dataSource.insertProduct();
        ArrayList<String> products = dataSource.getAllProducts();

        Log.d("SQL", String.valueOf(products.size()));

    }
}
