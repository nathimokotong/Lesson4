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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        dialog = new Dialog(MainActivity.this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

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
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.scoresid)
        {
            dialog.setContentView(R.layout.scores_layout);

            dialog.show();

            dialog.setCanceledOnTouchOutside(false);


            Toast.makeText(this,"Scores",Toast.LENGTH_SHORT).show();
        }

return true;
    }

    public void sports(View view)
{

    Intent intent = new Intent(MainActivity.this,Sports.class);

    startActivity(intent);

}

    public void close(View v)
    {

        dialog.dismiss();
    }

}
