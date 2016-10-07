package com.example.android.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.MenuItem;
import android.app.ActionBar;
import android.widget.Toast;


import java.util.Arrays;
import java.util.Collections;

public class Evolution extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    public String Evoscore;

    //score record
    int record;
    int totalscorecount;
    String totalscoreput;
    String key;

    TextView score;


    //text view questions
    TextView tx1;
    TextView tx2;
    TextView tx3;
    TextView tx4;


    //text view answers
    TextView A1;
    TextView A2;
    TextView A3;
    TextView A4;



    //user answer
    String ansa1;
    String ansa2;
    String ansa3;
    String ansa4;
    String ansa5;
    String ansa6;

    //Boolean if answer if wrong
    public Boolean answer1;
    public Boolean answer2;
    public Boolean answer3;
    public Boolean answer4;



    //radio group
    RadioGroup G1;
    RadioGroup G2;
    RadioGroup G3;
    RadioGroup G4;


    //Radio button
    RadioButton RB;
    RadioButton RB1;
    RadioButton RB2;
    RadioButton RB3;
    RadioButton RB4;

    RadioButton RB11;
    RadioButton RB22;
    RadioButton RB33;
    RadioButton RB44;

    RadioButton RB111;
    RadioButton RB222;
    RadioButton RB333;
    RadioButton RB444;

    RadioButton RB10;
    RadioButton RB20;
    RadioButton RB30;
    RadioButton RB40;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evolution);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        record = 0;
        score = (TextView) findViewById(R.id.scoreidev);

        answer1 = false;
        answer2 = false;
        answer3 = false;
        answer4 = false;

        String[] values = new String[]{"Which of the following is not an assumption of the Hardy–Weinberg equilibrium?"
                , "In a population of red (dominant allele) or white flowers, the frequency of red flowers is 91%. What is the frequency of the red allele?"
                , "Which of the following describes gene flow? "
                , "Which of the following conditions is not needed for natural selection to occur in a population?"};


        //text view questions
        tx1 = (TextView) findViewById(R.id.Q1ev);
        tx2 = (TextView) findViewById(R.id.Q2ev);
        tx3 = (TextView) findViewById(R.id.Q3ev);
        tx4 = (TextView) findViewById(R.id.Q4ev);

        tx1.setText(values[0]);
        tx2.setText(values[1]);
        tx3.setText(values[2]);
        tx4.setText(values[3]);

//____________________________________________________________

        A1 = (TextView) findViewById(R.id.Q1corretev);
        A2 = (TextView) findViewById(R.id.Q2corretev);
        A3 = (TextView) findViewById(R.id.Q3corretev);
        A4 = (TextView) findViewById(R.id.Q4corretev);

        G1 = (RadioGroup) findViewById(R.id.group1ev);
        G2 = (RadioGroup) findViewById(R.id.group2ev);
        G3 = (RadioGroup) findViewById(R.id.group3ev);
        G4 = (RadioGroup) findViewById(R.id.group4ev);

        //Radio buttons
        RB1 = (RadioButton) findViewById(R.id.Rb1Q1ev);
        RB2 = (RadioButton) findViewById(R.id.Rb2Q1ev);
        RB3 = (RadioButton) findViewById(R.id.Rb3Q1ev);
        RB4 = (RadioButton) findViewById(R.id.Rb4Q1ev);

        RB11 = (RadioButton) findViewById(R.id.Rb1Q2ev);
        RB22 = (RadioButton) findViewById(R.id.Rb2Q2ev);
        RB33 = (RadioButton) findViewById(R.id.Rb3Q2ev);
        RB44 = (RadioButton) findViewById(R.id.Rb4Q2ev);

        RB111 = (RadioButton) findViewById(R.id.Rb1Q3ev);
        RB222 = (RadioButton) findViewById(R.id.Rb2Q3ev);
        RB333 = (RadioButton) findViewById(R.id.Rb3Q3ev);
        RB444 = (RadioButton) findViewById(R.id.Rb4Q3ev);

        RB10 = (RadioButton) findViewById(R.id.Rb1Q4ev);
        RB20 = (RadioButton) findViewById(R.id.Rb2Q4ev);
        RB30 = (RadioButton) findViewById(R.id.Rb3Q4ev);
        RB40 = (RadioButton) findViewById(R.id.Rb4Q4ev);

        //shuffing radio buttons
        SetRedioGroup1(RB1, RB2, RB3, RB4);
        SetRedioGroup2(RB11, RB22, RB33, RB44);
        SetRedioGroup3(RB111, RB222, RB333, RB444);
        SetRedioGroup4(RB10, RB20, RB30, RB40);

        //RadioGroup onchange listener
         G1.setOnCheckedChangeListener(this);
        G2.setOnCheckedChangeListener(this);
        G3.setOnCheckedChangeListener(this);
        G4.setOnCheckedChangeListener(this);


    }


    public void onCheckedChanged(RadioGroup radioGroup, int i)
    {
        RB = (RadioButton) findViewById(i);


        if(radioGroup.getId() == R.id.group1ev)
        {

            if(RB.getText() == "Mating occurs preferentially")
            {

                // A1.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                ansa1 = RB.getText().toString();

                answer1 = true;

            }
            else
            {
                ansa1 = RB.getText().toString();
                //A1.setTextColor(getResources().getColor(android.R.color.holo_red_dark));

                answer1 = false;

            }
        }


        //__________________________________________________________________________________________

        if(radioGroup.getId() == R.id.group2ev)
        {

            if(RB.getText() == "70%")
            {

                // A1.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                ansa2 = RB.getText().toString();

                answer2 = true;

            }
            else
            {
                ansa2 = RB.getText().toString();
                //A1.setTextColor(getResources().getColor(android.R.color.holo_red_dark));

                answer2 = false;

            }
        }
        //__________________________________________________________________________________________

        if(radioGroup.getId() == R.id.group3ev)
        {

            if(RB.getText() == "migration")
            {
                ansa3 = RB.getText().toString();

                answer3 = true;


            }
            else
            {
                ansa3 = RB.getText().toString();

                answer3 = false;

            }
        }

        //_________________________________________________________________________________________

        if(radioGroup.getId() == R.id.group4ev)
        {

            if(RB.getText() == "Individuals must be able to move between populations.")
            {
                // A1.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                ansa4 = RB.getText().toString();

                answer4 = true;
            }
            else
            {
                ansa4 = RB.getText().toString();
                //A1.setTextColor(getResources().getColor(android.R.color.holo_red_dark));

                answer4 = false;
            }
        }

    }


    public void Submit(View v)
    {

        if("Mating occurs preferentially".equals(ansa1))
        {
            A1.setTextColor(getResources().getColor(android.R.color.holo_green_dark,null));

            record = record + 1;
        }
        else
        {
            A1.setTextColor(getResources().getColor(android.R.color.holo_red_dark,null));
        }


        if ("70%".equals(ansa2))
        {
            A2.setTextColor(getResources().getColor(android.R.color.holo_green_dark,null));

            record = record + 1;
            totalscorecount = record + 1;
        }
        else
        {
            A2.setTextColor(getResources().getColor(android.R.color.holo_red_dark,null));
        }


        if ("migration".equals(ansa3))
        {
            A3.setTextColor(getResources().getColor(android.R.color.holo_green_dark,null));

            record = record + 1;
            totalscorecount = record + 1;
        }

        else
        {
            A3.setTextColor(getResources().getColor(android.R.color.holo_red_dark,null));
        }

        if ("Individuals must be able to move between populations.".equals(ansa4))
        {
            A4.setTextColor(getResources().getColor(android.R.color.holo_green_dark,null));

            record = record + 1;
            totalscorecount = record + 1;
        }
        else
        {
            A4.setTextColor(getResources().getColor(android.R.color.holo_red_dark,null));
        }

        A1.setText(ansa1);
        A2.setText(ansa2);
        A3.setText(ansa3);
        A4.setText(ansa4);
        String tot = ""+record;

        if(record < 3)
        {

            score.setText("Sorry you only got "+tot+" out of 5 questions right");

        }
        else
        {
            score.setText("Congratulations :-) you got "+tot+" out of 5 questions right");

        }

        record = 0;

        G1.setVisibility(View.INVISIBLE);
        G2.setVisibility(View.INVISIBLE);
        G3.setVisibility(View.INVISIBLE);
        G4.setVisibility(View.INVISIBLE);

    }


    //SHUFFLE_______________________________SHUFFLE_______________________________SHUFFLE_____________
    public void SetRedioGroup1(RadioButton a,RadioButton b,RadioButton c,RadioButton d)
    {


        String[] indexanswer1 = new String[]{"Mating occurs preferentially.","The size of the population is large.","There is no migration." ,"There are no mutations."};

        Collections.shuffle(Arrays.asList(indexanswer1));

        a.setText(indexanswer1[0]);
        b.setText(indexanswer1[1]);
        c.setText(indexanswer1[2]);
        d.setText(indexanswer1[3]);

    }


    public void SetRedioGroup2(RadioButton a,RadioButton b,RadioButton c,RadioButton d)
    {

        String[] indexanswer2 = new String[]{"9%","30%","91%" ,"70%"};

        Collections.shuffle(Arrays.asList(indexanswer2));

        a.setText(indexanswer2[0]);
        b.setText(indexanswer2[1]);
        c.setText(indexanswer2[2]);
        d.setText(indexanswer2[3]);

    }


    public void SetRedioGroup3(RadioButton aaa,RadioButton bbb,RadioButton ccc,RadioButton ddd)
    {


        String[] indexanswer3 = new String[]{"random mating","migration","genetic drift" ,"selection"};

        Collections.shuffle(Arrays.asList(indexanswer3));

        aaa.setText(indexanswer3[0]);
        bbb.setText(indexanswer3[1]);
        ccc.setText(indexanswer3[2]);
        ddd.setText(indexanswer3[3]);

    }


    public void SetRedioGroup4(RadioButton aa,RadioButton bb,RadioButton cc,RadioButton dd)
    {

//"Fc Barcelona","Manchester Utd","AC Milan","Fc Porto"
//"Brazil","South Africa","Brazil","Hungary"
        String[] indexanswer4 = new String[]{"Individuals must be able to move between populations." ,
                                             "Variation must be genetically inherited.",
                                            "Certain variations allow an individual to produce more offspring that survive in the next generation."
                                            ,"There must be variations in the phenotypes of individuals in the population."};


        Collections.shuffle(Arrays.asList(indexanswer4));

        aa.setText(indexanswer4[0]);
        bb.setText(indexanswer4[1]);
        cc.setText(indexanswer4[2]);
        dd.setText(indexanswer4[3]);


    }

    public void show(View view)
    {

        G1.setVisibility(View.VISIBLE);
        G2.setVisibility(View.VISIBLE);
        G3.setVisibility(View.VISIBLE);
        G4.setVisibility(View.VISIBLE);
        A1.setText("");
        A2.setText("");
        A3.setText("");
        A4.setText("");
        score.setText("");

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        totalscoreput = Integer.toString(totalscorecount);

        Intent intent = new Intent(Evolution.this,MainActivity.class);

        Toast.makeText(Evolution.this,"Main menu select Quiz category",Toast.LENGTH_LONG).show();

        startActivity(intent);

    }
}