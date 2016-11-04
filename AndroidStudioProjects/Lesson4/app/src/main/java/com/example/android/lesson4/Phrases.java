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

public class Phrases extends AppCompatActivity implements TextToSpeech.OnInitListener {

    ImageView i1 ,i2 ,i3 ,i4 ,i5 ,i6 ,i7 ,i8 ,i9 ,i10;
    String[] phras;
    TextToSpeech speak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        phras = new String[]{"Hello","I am fine","I am happy / sad","Where can I get money changed?",
                "What is the room number?","Please may I look at the menu?","When do you open / close?"
                ,"Can I use your phone / computer?","Where are we going?","Let me go!"};

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Hello","Dumela"));
        words.add(new Word("I am fine","Ke phela hantle"));
        words.add(new Word("I am happy / sad","Ke thabile / hloname"));
        words.add(new Word("Where can I get money changed?","Nka tjhentjha tjhelete hokae?"));
        words.add(new Word("What is the room number?","Nomoro ya kamore ke mang?"));
        words.add(new Word("Please may I look at the menu?","Na nka kopa ho sheba menyu?"));
        words.add(new Word("When do you open / close?","Le bula neng / le kwala neng?"));
        words.add(new Word("Can I use your phone / computer?","Na nka sebedisa mohala / khomphutha ya hao?"));
        words.add(new Word("Where are we going?","Re ya kae?"));
        words.add(new Word("Let me go!","Ntumelle ke tsamaye!"));


        WordAdapter itemsAdapter = new WordAdapter(this,words);
        ListView listView = (ListView)findViewById(R.id.numberslist);
        listView.setAdapter(itemsAdapter);


        speak = new TextToSpeech(Phrases.this, (TextToSpeech.OnInitListener) this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // String num = String.valueOf(adapterView.getItemAtPosition(i));
                String num = phras[i];
                speak.setLanguage(Locale.US);
                speak.speak(num, TextToSpeech.QUEUE_ADD, null);


            }


        });


    }


    @Override
    public void onInit(int i) {

    }
}


