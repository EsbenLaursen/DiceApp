package com.example.esbenlaursen.diceapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ArrayList<Roll> rolls;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ListView mList = (ListView) findViewById(R.id.listViewHistory);


        Intent i = this.getIntent();
        rolls = (ArrayList) i.getSerializableExtra("rolls");
        adapter = new CustomAdapter(this, R.layout.custom_row, rolls);

        mList.setAdapter(adapter);


    }

    public void ClearHistoryOnClick(View view)
    {
         rolls.clear();
         adapter.notifyDataSetChanged();
    }

    public void GoBackOnClick(View view)
    {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("rolls", rolls);
        startActivity(i);
    }
}
