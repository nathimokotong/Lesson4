package com.example.android.lesson4;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class Family extends AppCompatActivity implements TextToSpeech.OnInitListener {

    ImageView i1 ,i2 ,i3 ,i4 ,i5 ,i6 ,i7 ,i8 ,i9 ,i10;
    String[] family;
TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        family = new String[]{"aunt","brother","cousin","daughter in law",
                "father","grandfather" ,"grandmother","mother","sister","uncle"};

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("aunt","rakgadi"));
        words.add(new Word("brother","moholwane"));
        words.add(new Word("cousin","motswala"));
        words.add(new Word("daughter in law","ngwetsi"));
        words.add(new Word("father", "ntate"));
        words.add(new Word("grandfather" ,"ntatemoholo"));
        words.add(new Word("grandmother","nkgono"));
        words.add(new Word("mother","mme"));
        words.add(new Word("sister","kgaitsedi"));
        words.add(new Word("uncle","malome"));


        WordAdapter itemsAdapter = new WordAdapter(this,words);
        ListView listView = (ListView)findViewById(R.id.numberslist);
        listView.setAdapter(itemsAdapter);

        tts = new TextToSpeech(this, (TextToSpeech.OnInitListener) this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // String num = String.valueOf(adapterView.getItemAtPosition(i));
                String num = family[i];
                tts.setLanguage(Locale.US);
                tts.speak(num, TextToSpeech.QUEUE_ADD, null);


            }


        });

    }

    @Override
    public void onInit(int i) {

    }
}
