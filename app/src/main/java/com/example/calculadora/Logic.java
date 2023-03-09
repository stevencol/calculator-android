package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class Logic {


    private final Operators operators = new Operators();


    protected String addNumber(String number, View v, AppCompatActivity app, TextView display) {

        number = display.getText().toString() == null ? "" : display.getText().toString();

        if (number.length() > 10) {
            Toast.makeText(app, "No se pue Agregar mas numeros", Toast.LENGTH_SHORT).show();
            return number;
        } else {

            if(display.getText().toString().contains(".") && v.getTag().toString().intern()=="." || display.getText().toString().contains(".")){
                System.out.println("sss");
                return number;
            }else{
                return number += v.getTag().toString();
            }
        }

    }

    protected TextView deleteDigit(TextView v, AppCompatActivity app) {
        String number;
        if (v.getText().toString().length() > 0) {
            number = v.getText().toString() == null ? "" : v.getText().toString().substring(0, v.getText().length() - 1);
            v.setText(number);
            return v;

        } else {
            Toast.makeText(app, "No hay nada que borrar", Toast.LENGTH_SHORT).show();
        }
        return v;
    }

    protected TextView deleteAll(TextView v, AppCompatActivity app) {

        if (v.getText().toString().length() > 0) {
            v.setText("");
            return v;

        } else {
            Toast.makeText(app, "No hay nada que borrar", Toast.LENGTH_SHORT).show();

        }
        return v;
    }

    protected String operar(View v, TextView display) {
  if(operators.getResult().intValue()>0){


  }
        return operators.checkLasOperator(v.getTag().toString(), new BigDecimal(display.getText().toString()));

    }

    public void reset(){
       operators.reset();

    }



}

