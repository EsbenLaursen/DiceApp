package com.example.esbenlaursen.diceapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Roll> rolls = new ArrayList<>();
    Random random;
    private int dices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       AddImagesToArray();

        dices = 6;

        NumberPicker picker = (NumberPicker) findViewById(R.id.numberPicker2);
        picker.setMaxValue(6);
        picker.setMinValue(1);
        picker.setValue(6);
        picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                dices = newVal;
                ImageView imageView1 = (ImageView) findViewById(R.id.diceView1);
                ImageView imageView2 = (ImageView) findViewById(R.id.diceView2);
                ImageView imageView3 = (ImageView) findViewById(R.id.diceView3);
                ImageView imageView4 = (ImageView) findViewById(R.id.diceView4);
                ImageView imageView5 = (ImageView) findViewById(R.id.diceView5);
                ImageView imageView6 = (ImageView) findViewById(R.id.diceView6);

                switch(newVal)
                {
                    case 1:
                         imageView1.setVisibility(View.VISIBLE);
                         imageView2.setVisibility(View.INVISIBLE);
                          imageView3.setVisibility(View.INVISIBLE);
                           imageView4.setVisibility(View.INVISIBLE);
                          imageView5.setVisibility(View.INVISIBLE);
                           imageView6.setVisibility(View.INVISIBLE); break;
                    case 2:
                        imageView1.setVisibility(View.VISIBLE);
                        imageView2.setVisibility(View.VISIBLE);
                        imageView3.setVisibility(View.INVISIBLE);
                        imageView4.setVisibility(View.INVISIBLE);
                        imageView5.setVisibility(View.INVISIBLE);
                        imageView6.setVisibility(View.INVISIBLE); break;
                    case 3:
                        imageView1.setVisibility(View.VISIBLE);
                        imageView2.setVisibility(View.VISIBLE);
                        imageView3.setVisibility(View.VISIBLE);
                        imageView4.setVisibility(View.INVISIBLE);
                        imageView5.setVisibility(View.INVISIBLE);
                        imageView6.setVisibility(View.INVISIBLE); break;
                    case 4:
                        imageView1.setVisibility(View.VISIBLE);
                        imageView2.setVisibility(View.VISIBLE);
                        imageView3.setVisibility(View.VISIBLE);
                        imageView4.setVisibility(View.VISIBLE);
                        imageView5.setVisibility(View.INVISIBLE);
                        imageView6.setVisibility(View.INVISIBLE); break;
                    case 5:
                        imageView1.setVisibility(View.VISIBLE);
                        imageView2.setVisibility(View.VISIBLE);
                        imageView3.setVisibility(View.VISIBLE);
                        imageView4.setVisibility(View.VISIBLE);
                        imageView5.setVisibility(View.VISIBLE);
                        imageView6.setVisibility(View.INVISIBLE); break;
                    case 6:
                        imageView1.setVisibility(View.VISIBLE);
                        imageView2.setVisibility(View.VISIBLE);
                        imageView3.setVisibility(View.VISIBLE);
                        imageView4.setVisibility(View.VISIBLE);
                        imageView5.setVisibility(View.VISIBLE);
                        imageView6.setVisibility(View.VISIBLE); break;

                }
            }
        });

        Intent i = getIntent();
        ArrayList updatedList = (ArrayList) i.getSerializableExtra("rolls");
        if(updatedList != null)
        {
            rolls = updatedList;
        }



        random = new Random();
    }

    private void AddImagesToArray() {
        ImageView img1 = (ImageView) findViewById(R.id.diceView1);
         img1.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.dice1, null));

        ImageView img2 = (ImageView) findViewById(R.id.diceView2);
        img2.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.dice2, null));

        ImageView img3 = (ImageView) findViewById(R.id.diceView3);
        img3.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.dice3, null));

        ImageView img4 = (ImageView) findViewById(R.id.diceView4);
        img4.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.dice4, null));

        ImageView img5 = (ImageView) findViewById(R.id.diceView5);
        img5.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.dice5, null));

        ImageView img6 = (ImageView) findViewById(R.id.diceView6);
        img6.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.dice6, null));

    }


    public void SeeHistoryOnClick(View v)
    {
        Intent i = new Intent(this, HistoryActivity.class);
        i.putExtra("rolls", rolls);
        startActivity(i);
    }



    public void RollDiceOnClick(View view)
    {
        //doesnt work
        //ImageView imageView = (ImageView) findViewById(R.id.diceView1); //imageview, der skal modificeres
       // Bitmap bitmap = ((BitmapDrawable) imageViews.get(2).getDrawable()).getBitmap();  //bitmap for det imageview som skal erstatte overstående
        //imageView.setImageResource(R.drawable.dice6);
        Toast.makeText(this, "Dice roll", Toast.LENGTH_LONG).show();

        ImageView imageView1 = (ImageView) findViewById(R.id.diceView1);
        ImageView imageView2 = (ImageView) findViewById(R.id.diceView2);
        ImageView imageView3 = (ImageView) findViewById(R.id.diceView3);
        ImageView imageView4 = (ImageView) findViewById(R.id.diceView4);
        ImageView imageView5 = (ImageView) findViewById(R.id.diceView5);
        ImageView imageView6 = (ImageView) findViewById(R.id.diceView6);

        ArrayList<Integer> numbers = new ArrayList<>();


        for(int i=0; i<dices; i++)
        {
            int ran = random.nextInt(6)+1;

            switch(i)
            {
                case 0: imageView1.setImageResource(getDrawablePls(ran)); break;
                case 1: imageView2.setImageResource(getDrawablePls(ran)); break;
                case 2: imageView3.setImageResource(getDrawablePls(ran)); break;
                case 3: imageView4.setImageResource(getDrawablePls(ran)); break;
                case 4: imageView5.setImageResource(getDrawablePls(ran)); break;
                case 5: imageView6.setImageResource(getDrawablePls(ran)); break;
            }
            numbers.add(0, ran);
        }
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        Roll roll = new Roll(timeStamp, numbers);
        rolls.add(roll);

    }

    public int getDrawablePls(int i)
    {
        switch(i)
        {
            case 1: return R.drawable.dice1;
            case 2: return R.drawable.dice2;
            case 3: return R.drawable.dice3;
            case 4: return R.drawable.dice4;
            case 5: return R.drawable.dice5;
            case 6: return R.drawable.dice6;
        }
        return 0;

    }


}
