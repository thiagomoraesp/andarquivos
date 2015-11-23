package com.example.thiago.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringWriter;

public class Ver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView sp_t = (TextView) findViewById(R.id.sp_t);
        TextView sp_i = (TextView) findViewById(R.id.sp_i);
        TextView is_t = (TextView) findViewById(R.id.is_t);
        TextView is_i = (TextView) findViewById(R.id.is_i);
        SharedPreferences settings = getSharedPreferences("chave",0);
        String texto = settings.getString("texto", "default");
        String inteiro = settings.getString("int", "default");

        sp_t.setText(texto);
        sp_i.setText(inteiro);


        try {
            FileInputStream fost = openFileInput("texto");
            FileInputStream fosi = openFileInput("inteiro");

            java.util.Scanner s = new java.util.Scanner(fost).useDelimiter("\\A");
            java.util.Scanner i = new java.util.Scanner(fosi).useDelimiter("\\A");

            is_t.setText(s.hasNext() ? s.next() : "");
            is_i.setText(i.hasNext() ? i.next() : "");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });






    }

}
