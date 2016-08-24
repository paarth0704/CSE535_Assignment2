package com.example.paarth.atry;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private TextView questions;

    private static final String TAG = "MainActivity";
    private int prime = 0;
    private int cprime = 0;
    private Button tbutton;
    private Button fbutton;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        questions = (TextView)findViewById(R.id.questions);
        prime = randomgenerator();
        questions.setText("Is " + prime + " a prime number?");

        cprime = checkPrime(prime);



        tbutton = (Button) findViewById(R.id.tbutton);
        tbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Clicked Correct");
                if(cprime==1) {
                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "InCorrect Answer", Toast.LENGTH_LONG).show();
                }
                fbutton.setEnabled(false);
                tbutton.setEnabled(false);

            }
        });



        fbutton = (Button) findViewById(R.id.fbutton);
        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Clicked Incorrect");
                if(cprime==0) {
                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "InCorrect Answer", Toast.LENGTH_LONG).show();
                }
                tbutton.setEnabled(false);
                fbutton.setEnabled(false);

            }
        });

        Button nbutton = (Button) findViewById(R.id.nbutton);
        nbutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Clicked Next");
                prime = randomgenerator();
                cprime = checkPrime(prime);
                questions.setText("Is " + prime + " a prime number?");

                tbutton.setEnabled(true);
                fbutton.setEnabled(true);
            }
        });


        Button hint = (Button) findViewById(R.id.hint);
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked Hint");
                Intent hintintent = new Intent(view.getContext(), HintActivity.class);
                startActivity(hintintent);


            }
        });


        Button cheat = (Button) findViewById(R.id.cheat);
        cheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked Cheat");
                Intent cheatintent = new Intent(view.getContext(),CheatActivity.class);
                cheatintent.putExtra("mycheat",cprime);
                startActivity(cheatintent);
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


    private int checkPrime(int number){

        for(int i=2; i<=number/2; i++){
            if(number % i == 0){
                return 0;
            }
        }
        return 1;
    }

    private int randomgenerator() {

        Random r = new Random();

        return r.nextInt(1000 - 1) + 1;
    }



}
