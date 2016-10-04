package com.example.android.justapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Information extends AppCompatActivity {

    TextView name;
    TextView surname;
    TextView age;
    TextView race;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_layout);


        name = (TextView) findViewById(R.id.txtNameDisp);
        surname = (TextView) findViewById(R.id.txtSurDisp);
        age = (TextView) findViewById(R.id.txtAgeDispl);
        race = (TextView) findViewById(R.id.txtRaceDispl);



        String n,s,a,r;

        n = getIntent().getStringExtra("name");
        s = getIntent().getStringExtra("surname");
        a = getIntent().getStringExtra("age");
        r = getIntent().getStringExtra("race");


        name.setText(n);
        surname.setText(s);
        age.setText(a);
        race.setText(r);

    }
}
