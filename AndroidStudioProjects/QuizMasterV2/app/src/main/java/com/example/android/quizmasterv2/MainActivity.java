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
    TextView bioscore;
    TextView historyscore;
  public String score1 = "0";
  public String score2 = "0";
  public String score3 = "0";
    int text = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        dialog = new Dialog(MainActivity.this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sportscore = (TextView) findViewById(R.id.sprortsscore);
        bioscore = (TextView) findViewById(R.id.bioscore);
        historyscore = (TextView) findViewById(R.id.historysscore);

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

            dialog(score1,score2,score3);

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
       // Intent intent = new Intent(MainActivity.this,Biology.class);

       // startActivity(intent);
    }


    public void dialog(String sc1,String sc2,String sc3)
    {
        dialog.setContentView(R.layout.scores_layout);

       sportscore.setText(sc1);
        bioscore.setText(sc2);
        historyscore.setText(sc3);
        dialog.show();
    }


}
