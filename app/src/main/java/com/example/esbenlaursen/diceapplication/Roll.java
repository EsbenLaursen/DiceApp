package com.example.esbenlaursen.diceapplication;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by EsbenLaursen on 20-02-2017.
 */

public class Roll implements Serializable {
    private ArrayList<Integer> diceNumbers;
    public String date;

    public Roll(String date, ArrayList<Integer> ints)
    {
        this.diceNumbers = ints;
        this.date = date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDiceNumbers(ArrayList<Integer> diceNumbers) {
        this.diceNumbers = diceNumbers;
    }

    public ArrayList<Integer> getDiceNumbers() {
        return diceNumbers;
    }
}
