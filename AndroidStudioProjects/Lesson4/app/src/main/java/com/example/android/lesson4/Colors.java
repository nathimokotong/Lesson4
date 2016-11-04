package com.example.android.lesson4;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Locale;

public class Colors extends AppCompatActivity implements TextToSpeech.OnInitListener{

    ImageView i1 ,i2 ,i3 ,i4 ,i5 ,i6 ,i7 ,i8 ,i9 ,i10;
    String[] colors;
   TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

      //  RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Rlayout);


        colors = new String[]{"black","white","gray",
                "red","dusty yellow","mustard yellow","green"};

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("black","tntsho",R.drawable.color_black));
        words.add(new Word("white","tshweu",R.drawable.color_white));
        words.add(new Word("gray","thokwa",R.drawable.color_gray));
        words.add(new Word("red","kgubedu",R.drawable.color_red));
        words.add(new Word("dusty yellow","putswa/bolou",R.drawable.color_dusty_yellow));
        words.add(new Word("mustard yellow","tshehla",R.drawable.color_mustard_yellow));
        words.add(new Word("green","tala",R.drawable.color_green));


        WordAdapter itemsAdapter = new WordAdapter(this,words);
        ListView listView = (ListView)findViewById(R.id.numberslist);
        listView.setAdapter(itemsAdapter);

        tts = new TextToSpeech(Colors.this, (TextToSpeech.OnInitListener) this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // String num = String.valueOf(adapterView.getItemAtPosition(i));
                String num = colors[i];
                tts.setLanguage(Locale.US);
                tts.speak(num, TextToSpeech.QUEUE_ADD, null);
            }
        });

    }

    @Override
    public void onInit(int i) {

    }
}