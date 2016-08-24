package com.example.paarth.atry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

public class HintActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView hint;
        String showhint = "A prime number is a whole number greater than 1, whose only two whole-number factors are 1 and itself. The first few prime numbers are 2, 3, 5, 7, 11, 13, 17, 19, 23, and 29.";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hint = (TextView)findViewById(R.id.hint);
        hint.setText(showhint);


    }

    @Override
    public void onBackPressed() {


        Intent intent = new Intent();

        Toast.makeText(HintActivity.this, "User has received a hint",
                Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK, intent);
        finish();
    }

}
