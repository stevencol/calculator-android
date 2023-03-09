package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.math.BigDecimal;

public class Operators {
  public int i =0;
    private BigDecimal result;
    private BigDecimal number;
    private BigDecimal number2;
    private String lastoperator;


    protected Operators() {
        this.result = new BigDecimal(0);
        this.number = new BigDecimal(0);
        this.number2 = new BigDecimal(0);
        this.lastoperator = "";
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public BigDecimal getNumber2() {
        return number2;
    }

    public void setNumber2(BigDecimal number2) {
        this.number2 = number2;
    }

    public String getLastoperator() {
        return lastoperator;
    }

    public void setLastoperator(String lastoperator) {
        this.lastoperator = lastoperator;
    }

    protected String addition(BigDecimal value1, BigDecimal value2) {
        return String.valueOf(value1.add(value2));
    }


    protected String subtraction(BigDecimal value1, BigDecimal value2) {
        return String.valueOf(value2.subtract(value1));
    }


    protected String multiplication(BigDecimal value1, BigDecimal value2) {
        return String.valueOf(value1.multiply(value2));

    }

    protected String division(BigDecimal value1, BigDecimal value2) {

        if (value2.intValue() == 0) {
            Toast.makeText(new AppCompatActivity(), "No se puede diivir por cerro", Toast.LENGTH_SHORT).show();
            return "";
        } else {
            return String.valueOf(value2.divide(value1));
        }

    }


    protected String checkLasOperator(String currentOperator, BigDecimal number) {

        if (this.result.intValue() == 0  && number2.intValue()==0 && this.lastoperator.equals("")) {

            this.number2 = number;
            this.number = new BigDecimal(0);
            this.lastoperator = currentOperator;
            currentOperator = "";
            return String.valueOf("");

        } else if (this.lastoperator.toString().intern()!="=" && this.lastoperator.toString().intern() !=""&& this.number2.intValue() != 0) {
            System.out.println(this.getNumber2());
            System.out.println("si");
            System.out.println(number + "+ " +number2);
            result = new BigDecimal(operate(lastoperator , number));
            System.out.println(result);
            this.lastoperator = currentOperator.equals("=") ? "" : currentOperator;
            currentOperator = "";
          this.lastoperator = "";
             BigDecimal rfinal = this.result;
            this.result = new  BigDecimal(0);
            this.number = new BigDecimal(0);
            this.number2 = new  BigDecimal(0);

            return String.valueOf(rfinal);

        }
        if (currentOperator.equalsIgnoreCase("=")) {
            System.out.println("=");
            operate(lastoperator , number);
            System.out.println(lastoperator);;
            this.number2 = this.result;
            this.number = new BigDecimal(0);
            return String.valueOf(this.result);
        }

        return String.valueOf(this.result);
    }




    protected String  operate(String operator, BigDecimal number) {
        switch (operator) {
            case "+":
                  this.result = new BigDecimal(addition(number, this.number2));

                break;
            case "-":
                this.result = new BigDecimal(subtraction(number, this.number2));

                break;
            case "x":
                this.result = new BigDecimal(multiplication(number, this.number2));
                break;
            case "/":
                this.result = new BigDecimal(division(number, this.number2));
                break;

            case "=":
                System.out.println("sii");
                checkLasOperator(this.lastoperator, this.number2);
                break;

            default:

                break;
        }
        return String.valueOf(this.result);
    }

    public void reset(){
        this.number2=new BigDecimal(0);
        this.number=new BigDecimal(0);
        this.result =  new BigDecimal(0);
        this.lastoperator="";
    }
}
