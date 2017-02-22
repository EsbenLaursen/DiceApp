package com.example.esbenlaursen.diceapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by EsbenLaursen on 20-02-2017.
 */

public class CustomAdapter extends ArrayAdapter<Roll> {

    private ArrayList<Roll> rolls;


    public CustomAdapter(Context context, int resource, ArrayList<Roll> rolls) {
        super(context, R.layout.custom_row, rolls );
        this.rolls = rolls;
    }
    @Override
    public View getView(int position, View v, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent, false);

            TextView date = (TextView) customView.findViewById(R.id.textViewDate);
            TextView rollNumber = (TextView) customView.findViewById(R.id.textViewRoll);

            Roll currentRoll = getItem(position);

            ArrayList<Integer> numbers = currentRoll.getDiceNumbers();

            date.setText(currentRoll.date);
            rollNumber.setText(numbers.toString());


        return customView;
    }

    @Override
    public int getCount() {
        return rolls.size();
    }

}
