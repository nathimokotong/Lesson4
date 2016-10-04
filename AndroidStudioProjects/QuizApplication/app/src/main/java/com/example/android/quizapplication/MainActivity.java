package com.example.android.quizapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    public  int i = 0;
    TextView txtV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






    }

public void change(View v)
{

    Intent intent = new Intent(MainActivity.this,Soccer.class);

    startActivity(intent);

}


    public void changeEv(View v)
    {

        Intent intent = new Intent(MainActivity.this,Evolution.class);

        startActivity(intent);

    }



    public void changeMov(View v)
    {

        Intent intent = new Intent(MainActivity.this,Movie.class);

        startActivity(intent);

    }


}
