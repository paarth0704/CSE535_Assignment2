package com.example.paarth.atry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings({"ALL", "FieldCanBeLocal"})
public class CheatActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView cheat;
        String incorrect = "The answer is Incorrect";
        String correct = "The answer is Correct";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cheat = (TextView) findViewById(R.id.cheat);
        int showcheat = this.getIntent().getIntExtra("mycheat", 0);

        if(showcheat==0){

            cheat.setText(incorrect);


        }

        else{

            cheat.setText(correct);

        }



    }


    @Override
    public void onBackPressed() {


        Intent intent = new Intent();

        Toast.makeText(CheatActivity.this, "User has received a cheat",
                Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK, intent);
        finish();
    }

}
