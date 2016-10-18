package com.example.android.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(5000);
        rotate.setInterpolator(new LinearInterpolator());

        ImageView image= (ImageView) findViewById(R.id.imagesplash);

        image.startAnimation(rotate);


        Thread myThread = new Thread()
        {

            public void run()
            {

                try {
                    sleep(10000);

                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);

                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }



        };

        myThread.start();




    }
}
