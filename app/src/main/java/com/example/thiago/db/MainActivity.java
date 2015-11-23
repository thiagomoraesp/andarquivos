package com.example.thiago.db;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.util.Log;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void salvaressadelicia(View view) throws FileNotFoundException,java.io.IOException
    {
        RadioGroup radio = (RadioGroup) findViewById(R.id.radioGroup);
        int checado = radio.getCheckedRadioButtonId();

        if(checado ==  findViewById(R.id.preferences).getId())
        {
            salvarPrefs(view);
        }
        else
        {
            salvarinternal(view);
        }


    }

    public void salvarPrefs(View view)
    {

        TextView campo_de_texto = (TextView) findViewById(R.id.texto);
        TextView campo_de_inteiro = (TextView) findViewById(R.id.inteiro);

        SharedPreferences settings = getSharedPreferences("chave",0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("texto", String.valueOf(campo_de_texto.getText()));
        editor.putString("int", String.valueOf(campo_de_inteiro.getText()));
        editor.commit();

    }




    public void salvarinternal(View view) throws FileNotFoundException,java.io.IOException  {

        TextView campo_de_texto = (TextView) findViewById(R.id.texto);
        TextView campo_de_inteiro = (TextView) findViewById(R.id.inteiro);



        FileOutputStream fos = openFileOutput("texto", Context.MODE_PRIVATE);
        fos.write(campo_de_texto.getText().toString().getBytes());
        fos.close();

        FileOutputStream fosi = openFileOutput("inteiro", Context.MODE_PRIVATE);
        fosi.write(campo_de_inteiro.getText().toString().getBytes());
        fosi.close();

    }


    public void exibir(View view)
    {
        Intent intent = new Intent(MainActivity.this, Ver.class);
        MainActivity.this.startActivity(intent);
    }


}
