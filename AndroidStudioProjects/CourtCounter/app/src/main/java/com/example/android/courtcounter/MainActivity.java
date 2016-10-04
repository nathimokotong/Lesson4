package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button two;
    Button three;
    TextView score;
    TextView scoreB;
    public int score_Team_A = 0;
    public int score_Team_B = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void add_three_point(View v)
    {

        score_Team_A = score_Team_A + 3;
        display(score_Team_A );

    }


    public void add_two_point(View v)
    {

        score_Team_A = score_Team_A + 2;
        display(score_Team_A );

    }


    public void add_one_point(View v)
    {

        score_Team_A = score_Team_A + 1;
        display(score_Team_A );

    }






    public void add_three_pointB(View v)
    {

        score_Team_B = score_Team_B + 3;
        displayB(score_Team_B );

    }


    public void add_two_pointB(View v)
    {

        score_Team_B = score_Team_B + 2;
        displayB(score_Team_B );

    }


    public void add_one_pointB(View v)
    {

        score_Team_B = score_Team_B + 1;
        displayB(score_Team_B );

    }


    public void display(int a)
    {

        score = (TextView) findViewById(R.id.txtScore);

        score.setText(""+a);

    }


    public void displayB(int a)
    {

        scoreB = (TextView) findViewById(R.id.txtScoreB);

        scoreB.setText(""+a);

    }



    public void resetAll(View v)
    {
        score_Team_A = 0;
        score_Team_B = 0;

        displayB(score_Team_B);
        display(score_Team_A);

    }



}
