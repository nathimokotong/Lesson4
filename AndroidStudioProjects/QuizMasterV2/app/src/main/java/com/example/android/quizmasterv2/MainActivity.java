package com.example.android.quizmasterv2;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Dialog dialog;
    Button button;
    TextView sportscore;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        dialog = new Dialog(MainActivity.this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sportscore = (TextView) findViewById(R.id.sprortsscore);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_layout,menu);


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.scoresid)
        {


            dialog.show();

            text = getIntent().getExtras().getString("score");

            sportscore.setText(text);

            Toast.makeText(this,"Scores",Toast.LENGTH_SHORT).show();

            dialog.setContentView(R.layout.scores_layout);
        }

return true;
    }

    public void sports(View view)
{

    Intent intent = new Intent(MainActivity.this,Sports.class);

    startActivity(intent);

}



}
