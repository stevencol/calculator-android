package com.example.calculadora;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final Logic logic = new Logic();
    private final LruCache lruCache = new LruCache<String, String>(10 * 1024 * 1024);
    private TextView display;
    private Button myButton;

    @Override
    public void onConfigurationChanged(Configuration congfi) {
        super.onConfigurationChanged(congfi);
        if (congfi.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_land);
        } else if (congfi.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int widt = displayMetrics.widthPixels;
        int heig = displayMetrics.heightPixels;
        boolean landscape = widt > heig;
        if (landscape) {
            setContentView(R.layout.activity_main_land);
            display = (TextView) findViewById(R.id.display);

        } else {
            setContentView(R.layout.activity_main);
            display = (TextView) findViewById(R.id.display);
        }

        if (savedInstanceState != null) {

            display.setText(savedInstanceState.getString("number"));
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("number", display.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstance) {
        super.onRestoreInstanceState(saveInstance);
        this.display.setText(saveInstance.getString("number"));
    }

    public void agregar(View v) {

        display.setText(logic.addNumber(display.getText().toString(), v, this, this.display));


    }

    public void delete(View v) {

        logic.deleteDigit(this.display, this);


    }


    public void deleteAll(View v) {
        logic.deleteAll(this.display, this);

    }

    public void operar(View v) {
        System.out.println("entra al operador");
        if(v.getTag().toString().equals("Delete") ){
       Toast.makeText(this, "Funcion en desarollo" , Toast.LENGTH_SHORT).show();
        }
        if(this.display.getText().toString().equals("")){
            Toast.makeText(this, "No hay nada que operar", Toast.LENGTH_SHORT).show();
        }else{
            this.display.setText(logic.operar(v, this.display));
        }


    }

    public void reset(View v){
  logic.reset();
  this.display.setText("");
    }


}

