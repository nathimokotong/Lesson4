package com.example.android.lesson4;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;

import android.speech.tts.TextToSpeech;
import android.util.Log;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.Toast;


public class Numbers extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextToSpeech tts;
    String[] numbrs;
    String[] language;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

      //  i1.setImageDrawable(getResources().getDrawable(R.drawable.one));


      //  preferences = getSharedPreferences("score",0);
        preferences = getSharedPreferences("language",0);
        String lang = preferences.getString("lang","none");

        language = new String[]{"one","two","three","four","five","six","seven","eight","nine","ten"};

        if(lang == "st")
        {
            language = new String[]{"tee","pedi","tharo","nne","hlano","tshela","supa","sewai","senyane","lesome"};
        }
        if(lang == "za")
        {
            language = new String[]{"one","two","three","four","five","six","seven","eight","nine","ten"};
        }

                ArrayList<Word> words = new ArrayList<Word>();

        numbrs = new String[]{"one","two","three","four","five","six","seven","eight","nine","ten"};

        words.add(new Word("lutti",language[0],R.drawable.number_one));
        words.add(new Word("otiiko",language[1],R.drawable.number_two));
        words.add(new Word("tolookosu",language[2],R.drawable.number_three));
        words.add(new Word("oyyisa",language[3],R.drawable.number_four));
        words.add(new Word("massokka",language[4],R.drawable.number_five));
        words.add(new Word("temmokka",language[5],R.drawable.number_six));
        words.add(new Word("kenekaku",language[6],R.drawable.number_seven));
        words.add(new Word("kawinta",language[7],R.drawable.number_eight));
        words.add(new Word("wo’e",language[8],R.drawable.number_nine));
        words.add(new Word("na’aacha",language[9],R.drawable.number_ten));


        tts = new TextToSpeech(this, (TextToSpeech.OnInitListener) this);


    WordAdapter itemsAdapter = new WordAdapter(this,words,R.color.colorNumbers);
        ListView listView = (ListView)findViewById(R.id.numberslist);
        listView.setAdapter(itemsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               // String num = String.valueOf(adapterView.getItemAtPosition(i));
                String num = numbrs[i];
                tts.setLanguage(Locale.US);
                tts.speak(num, TextToSpeech.QUEUE_ADD, null);

            }
        });

    }


    @Override
    public void onInit(int i) {

    }

    @Override
    protected void onPause() {
        if(tts != null)
        {
            tts.stop();
            //shutdown not to buffer
            tts.shutdown();
        }
        super.onPause();
    }
}
