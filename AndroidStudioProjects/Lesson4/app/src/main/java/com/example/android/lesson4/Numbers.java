package com.example.android.lesson4;

import android.app.ActionBar;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.speech.tts.TextToSpeech;
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

    TextToSpeech speek;
    TextToSpeech tts;
    String[] numbrs;
    ImageView[] imageViews;
    ImageView i1 ,i2 ,i3 ,i4 ,i5 ,i6 ,i7 ,i8 ,i9 ,i10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

      //  i1.setImageDrawable(getResources().getDrawable(R.drawable.one));



        ArrayList<Word> words = new ArrayList<Word>();

        numbrs = new String[]{"one","two","three","four","five","six","seven","eight","nine","ten"};

        words.add(new Word("one","tee",R.drawable.number_one));
        words.add(new Word("two","pedi",R.drawable.number_two));
        words.add(new Word("three","tharo",R.drawable.number_three));
        words.add(new Word("four","nne",R.drawable.number_four));
        words.add(new Word("five","hlano",R.drawable.number_five));
        words.add(new Word("six","tshela",R.drawable.number_six));
        words.add(new Word("seven","supa",R.drawable.number_seven));
        words.add(new Word("eight","sewai",R.drawable.number_eight));
        words.add(new Word("nine","senyane",R.drawable.number_nine));
        words.add(new Word("ten","lesome",R.drawable.number_ten));


        tts = new TextToSpeech(this, (TextToSpeech.OnInitListener) this);


    WordAdapter itemsAdapter = new WordAdapter(this,words);
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
}
