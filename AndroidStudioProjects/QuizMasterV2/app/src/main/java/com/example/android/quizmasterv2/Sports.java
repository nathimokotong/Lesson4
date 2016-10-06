package com.example.android.quizmasterv2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import android.support.v7.app.ActionBar;

public class Sports extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    Dialog builder;
    String itemselected;
    int radiobuttoncount;
    int points;
    String sentance;
    RadioButton radioBtn;
    public String radiobtnString = "";
    String[] options;
    public String line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_sports);

        builder = new Dialog(Sports.this);

        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);

        String[] values = new String[] {"Who is the only player to have won silverware at both Manchester United and Liverpool?"
                ,"Who is the only player to have scored in a Champions League final, FA Cup final, UEFA Cup final and League Cup final?"
                ,"Who is the only player to have scored a hat-trick in all four tiers of professional football in England, FA Cup, League Cup and at international level?"
                , "Who is the only player to have scored in the Glasgow, Merseyside and Manchester derbies?","Which is the national sport of Canada?","Archery is the national sport of which country?"
                , "______ has Cricket as its national sports.","_______ is the national sport of Turkey","When was the Commonwealth game started?","Which was the host country in 1998 for Asian Games?"};

        Collections.shuffle(Arrays.asList(values));

        String q1,q2,q3,q4,q5,q6,q7,q8,q9,q10;

                q1 = values[0];
                q2 = values[1];
                q3 = values[2];
                q4 = values[3];
                q5 = values[4];
                q6 = values[5];
                q7 = values[6];
                q8 = values[7];
                q9 = values[8];
                q10 = values[9];

        String[] rearranged = new String[]{q1,q2,q3,q4,q5,q6,q7,q8,q9,q10};

        ListAdapter theAddptr = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,rearranged);
        ListView theListView = (ListView) findViewById(R.id.listID);
        theListView.setAdapter(theAddptr);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                line = String.valueOf(adapterView.getItemAtPosition(pos));
            populate(line);
            dialog(adapterView,pos,options);



            }

        });



    }



    public void dialog(AdapterView adapterView, int pos,String[] arry)
    {


        builder.setContentView(R.layout.radiobutton);

        List<String> stringList = new ArrayList<String>();

        //Collections.shuffle(Arrays.asList(arry));

        for (int i = 0;i < 4;i++)
        {
            stringList.add(arry[i]);
        }

        final RadioGroup radioGroup = (RadioGroup) builder.findViewById(R.id.radiogroup);

        for(int i=0;i<stringList.size();i++){
            RadioButton rb = new RadioButton(Sports.this); // dynamically creating RadioButton and adding to RadioGroup.
            rb.setText(stringList.get(i));
            radioGroup.addView(rb);

        }


        Button donebtn = new Button(Sports.this);
        donebtn.setText("DONE");
        radioGroup.addView(donebtn);
        builder.show();
        builder.setCanceledOnTouchOutside(false);




            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i)
                {
                    int pos = radioGroup.getCheckedRadioButtonId();
                     points = point(line,pos);

                    radioGroup.setOnCheckedChangeListener(this);

                      Toast.makeText(Sports.this,"Point(s) "+ points,Toast.LENGTH_SHORT).show();
                }
            });





        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radio = radioGroup.getCheckedRadioButtonId();
                radioGroup.clearCheck();
                builder.dismiss();

               Toast.makeText(Sports.this,"Point(s) "+ radio,Toast.LENGTH_LONG).show();
            }
        });



    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i)
    {

        radioBtn = (RadioButton)findViewById(i);
        radiobtnString = radioBtn.getText().toString();
      //  Toast.makeText(Sports.this,radiobtnString,Toast.LENGTH_LONG).show();

    }


    public void populate(String sentances)
    {
        /* "Which is the national sport of Canada?","Archery is the national sport of which country?"
                , "______ has Cricket as its national sports.","_______ is the national sport of Turkey","When was the Commonwealth game started?","Which was the host country in 1998 for Asian Games?"*/

        if("Which is the national sport of Canada?".equals(sentances))
        {

            options = new String[]{"Lacrosse/Ice hockey","Cricket" ,"Field hockey","Volleyball"};

        }

        if("Archery is the national sport of which country?".equals(sentances))
        {

            options = new String[]{"Afghanistan" ,"Bhutan" ,"Japan" ,"India"};

        }

        if("______ has Cricket as its national sports.".equals(sentances))
        {

            options = new String[]{"India","Jamaica" ,"Sri Lanka","United States"};

        }

        if("_______ is the national sport of Turkey".equals(sentances))
        {

            options = new String[]{"Wrestling" ,"Rugby union" ,"Golf" ,"Basketball"};

        }

        if("When was the Commonwealth game started?".equals(sentances))
        {

            options = new String[]{"1930" ,"1934" ,"1938" ,"1950"};

        }

        if("Which was the host country in 1998 for Asian Games?".equals(sentances))
        {

            options = new String[]{"Thailand" ,"Philippines" ,"South Korea" ,"China"};

        }

        if("Who is the only player to have won silverware at both Manchester United and Liverpool?".equals(sentances))
        {

            options = new String[]{"Adam Johnson","Andy Cole","David Becham","Michael Owen"};

        }

        if("Who is the only player to have scored in a Champions League final, FA Cup final, UEFA Cup final and League Cup final?".equals(sentances))
        {

            options = new String[]{"Steven Gerrard","Robinho","Sergio Agüero","Wayne Rooney"};

        }

        if("Who is the only player to have scored a hat-trick in all four tiers of professional football in England, FA Cup, League Cup and at international level?".equals(sentances))
        {

            options = new String[]{"Robert Earnshaw","Christiano Ronaldo","Eden Hazard","Yaya Toure"};

        }

        if("Who is the only player to have scored in the Glasgow, Merseyside and Manchester derbies?" .equals(sentances))
        {

            options = new String[]{"Pep Guardiola","Andrei Kanchelskis","Jomo Sono","David Silva"};

        }



    }

    public int point(String sm, int index)
    {

        int point = 0;

        if("Which is the national sport of Canada?".equals(sm) && index == 1)
        {

            point++;

        }

        if("Archery is the national sport of which country?".equals(sm) && index == 2)
        {

            point++;


        }

        if("______ has Cricket as its national sports.".equals(sm) && index == 2)
        {

            point++;


        }

        if("_______ is the national sport of Turkey".equals(sm) && index == 1)
        {

            point++;


        }

        if("When was the Commonwealth game started?".equals(sm) && index == 1)
        {

            point++;


        }

        if("Which was the host country in 1998 for Asian Games?".equals(sm) && index == 1)
        {

            point++;


        }

        if("Who is the only player to have won silverware at both Manchester United and Liverpool?".equals(sm) && index == 4)
        {
            point++;

        }
        if("Who is the only player to have scored in a Champions League final, FA Cup final, UEFA Cup final and League Cup final?".equals(sm) && index == 1)
        {

            point++;

        }

        if("Who is the only player to have scored a hat-trick in all four tiers of professional football in England, FA Cup, League Cup and at international level?".equals(sm) && index == 1)
        {

            point++;
        }

        if("Who is the only player to have scored in the Glasgow, Merseyside and Manchester derbies?".equals(sm) && index == 2)
        {

            point++;

        }


        return point;
    }

}
