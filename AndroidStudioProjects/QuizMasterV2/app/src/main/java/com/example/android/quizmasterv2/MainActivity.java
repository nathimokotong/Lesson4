package com.example.android.quizmasterv2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.RelativeLayout.*;

public class MainActivity extends AppCompatActivity {

    Dialog builder;
    TextView txtsport;
    String score;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String Enterscor;

    String Bioscr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTitle(" Quiz Master");

        builder = new Dialog(MainActivity.this);

        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = new MenuInflater(this);
       inflater.inflate(R.menu.menu_layout,menu);


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {



        if(item.getItemId() == R.id.scoresid)
        {

             preferences = getSharedPreferences("score",0);

            score = preferences.getString("edtscore","not answered");

             Enterscor = preferences.getString("entscore","not answered");

           Bioscr = preferences.getString("bioscore","not answered");

            editor = preferences.edit();

            final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Sports : "+score +"\n Biology :" + Bioscr+ "\n Entertainment :"+Enterscor);
            builder1.setCancelable(true);
            builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    if(!"not answered".equals(score)&& !"not answered".equals(Bioscr) && !"not answered".equals(Enterscor))
                    {

                        editor.clear();
                        Toast.makeText(MainActivity.this, "All topics answered scores reseted", Toast.LENGTH_SHORT).show();
                        editor.commit();

                    }

                }
            });

            builder1.show();
        }

return true;
    }

    public void sports(View view)
{

    Intent intent = new Intent(MainActivity.this,Sports.class);

    startActivity(intent);

}

    public void biology(View view)
    {
       Intent intent = new Intent(MainActivity.this,Biology.class);

        startActivity(intent);
    }

    public void entertainment(View view)
    {
        Intent intent = new Intent(MainActivity.this,Entertainment.class);

        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }
}


