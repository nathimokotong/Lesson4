package com.example.android.lesson4;

import android.content.SharedPreferences;
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
    String[] numbrs , language;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //  i1.setImageDrawable(getResources().getDrawable(R.drawable.one));


        preferences = getSharedPreferences("score",0);

        String lang = preferences.getString("lang","za");

        language = new String[]{"aunt","brother","cousin","younger sister",
                "father","grandfather" ,"grandmother","mother","sister","uncle"};

        if(lang == "st")
        {
            language = new String[]{"tee","pedi","tharo","nne","hlano","tshela","supa","sewai","senyane","lesome"};
        }
        if(lang == "za")
        {
            language = new String[]{"aunt","brother","cousin","younger sister",
                    "father","grandfather" ,"grandmother","mother","sister","uncle"};
        }
        family = new String[]{"aunt","brother","cousin","younger sister",
                "father","grandfather" ,"grandmother","mother","sister","uncle"};

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("aunt","rakgadi",R.drawable.family_older_sister));
        words.add(new Word("brother","moholwane",R.drawable.family_younger_brother));
        words.add(new Word("cousin","motswala",R.drawable.family_younger_brother));
        words.add(new Word("younger sister","ngwetsi",R.drawable.family_younger_sister));
        words.add(new Word("father", "ntate",R.drawable.family_father));
        words.add(new Word("grandfather" ,"ntatemoholo",R.drawable.family_grandfather));
        words.add(new Word("grandmother","nkgono",R.drawable.family_grandmother));
        words.add(new Word("mother","mme",R.drawable.family_mother));
        words.add(new Word("sister","kgaitsedi",R.drawable.family_daughter));
        words.add(new Word("uncle","malome",R.drawable.family_older_brother));


        WordAdapter itemsAdapter = new WordAdapter(this,words,R.color.colorFamily);
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
