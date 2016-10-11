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


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

/*
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

            Intent intent = new Intent(MainActivity.this,Marks.class);
            startActivity(intent);

        }

return true;
    }
*/
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





}
