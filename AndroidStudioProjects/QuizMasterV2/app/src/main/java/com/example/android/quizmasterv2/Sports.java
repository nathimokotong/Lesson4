package com.example.android.quizmasterv2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
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

public class Sports extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    public String radiobtnString = "";
    int total;
    public String line;
    Dialog builder;
    String itemselected;
    int radiobuttoncount;
    int points;
    String ref = "score";
    String sentance;
    RadioButton radioBtn;
    String[] options;
    Boolean groupChck = false;
    String txt = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_sports);

        builder = new Dialog(Sports.this);

        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.LayoutID);

        linearLayout.setBackground(getResources().getDrawable(R.drawable.sportsback));

        String[] values = new String[]{"Who is the only player to have won silverware at both Manchester United and Liverpool?"
                , "Who is the only player to have scored in a Champions League final, FA Cup final, UEFA Cup final and League Cup final?"
                , "Who is the only player to have scored a hat-trick in all four tiers of professional football in England, FA Cup, League Cup and at international level?"
                , "Who is the only player to have scored in the Glasgow, Merseyside and Manchester derbies?", "Which is the national sport of Canada?", "Archery is the national sport of which country?"
                , "______ has Cricket as its national sports.", "_______ is the national sport of Turkey", "When was the Commonwealth game started?", "Which was the host country in 1998 for Asian Games?"};

        Collections.shuffle(Arrays.asList(values));

        String q1, q2, q3, q4, q5, q6, q7, q8, q9, q10;

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

        String[] rearranged = new String[]{q1, q2, q3, q4, q5, q6, q7, q8, q9, q10};

        ListAdapter theAddptr = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rearranged);
        ListView theListView = (ListView) findViewById(R.id.listID);
        theListView.setAdapter(theAddptr);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                groupChck = false;
               adapterView.getChildAt(pos).setBackgroundColor(Color.YELLOW);
                line = String.valueOf(adapterView.getItemAtPosition(pos));
                populate(line);
                dialog(adapterView, pos, options);
                adapterView.getChildAt(pos).setOnClickListener(null);

            }

        });

    }


    public void dialog(AdapterView adapterView, int pos, String[] arry) {


        builder.setContentView(R.layout.radiobutton);

        List<String> stringList = new ArrayList<String>();

        //Collections.shuffle(Arrays.asList(arry));

        for (int i = 0; i < 4; i++) {
            stringList.add(arry[i]);
        }

        final RadioGroup radioGroup = (RadioGroup) builder.findViewById(R.id.radiogroup);

        for (int i = 0; i < stringList.size(); i++) {
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
            public void onCheckedChanged(RadioGroup radioGroup, int i) {


                RadioButton rd = (RadioButton) radioGroup.findViewById(i);
                txt = rd.getText().toString();

                // radioGroup.setOnCheckedChangeListener(this);
                if(txt.length() > 0)
                {

                    groupChck = true;
                }


            }
        });


        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(groupChck == true)
                {
                    points = point(line, txt);
                    total = total + points;
                    builder.dismiss();
                }
                else if(groupChck == false)
                {
                 Toast.makeText(Sports.this,"Please select answer ",Toast.LENGTH_LONG).show();
                }

                }
        });


    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        radioBtn = (RadioButton) findViewById(i);
        radiobtnString = radioBtn.getText().toString();
        //  Toast.makeText(Sports.this,radiobtnString,Toast.LENGTH_LONG).show();

    }


    public void populate(String sentances) {
        /* "Which is the national sport of Canada?","Archery is the national sport of which country?"
                , "______ has Cricket as its national sports.","_______ is the national sport of Turkey","When was the Commonwealth game started?","Which was the host country in 1998 for Asian Games?"*/

        if ("Which is the national sport of Canada?".equals(sentances)) {

            options = new String[]{"Lacrosse/Ice hockey", "Cricket", "Field hockey", "Volleyball"};
            Collections.shuffle(Arrays.asList(options));

        }

        if ("Archery is the national sport of which country?".equals(sentances)) {

            options = new String[]{"Afghanistan", "Bhutan", "Japan", "India"};
            Collections.shuffle(Arrays.asList(options));
        }

        if ("______ has Cricket as its national sports.".equals(sentances)) {

            options = new String[]{"India", "Jamaica", "Sri Lanka", "United States"};
            Collections.shuffle(Arrays.asList(options));
        }

        if ("_______ is the national sport of Turkey".equals(sentances)) {

            options = new String[]{"Wrestling", "Rugby union", "Golf", "Basketball"};
            Collections.shuffle(Arrays.asList(options));
        }

        if ("When was the Commonwealth game started?".equals(sentances)) {

            options = new String[]{"1930", "1934", "1938", "1950"};
            Collections.shuffle(Arrays.asList(options));
        }

        if ("Which was the host country in 1998 for Asian Games?".equals(sentances)) {

            options = new String[]{"Thailand", "Philippines", "South Korea", "China"};
            Collections.shuffle(Arrays.asList(options));
        }

        if ("Who is the only player to have won silverware at both Manchester United and Liverpool?".equals(sentances)) {

            options = new String[]{"Adam Johnson", "Andy Cole", "David Becham", "Michael Owen"};
            Collections.shuffle(Arrays.asList(options));
        }

        if ("Who is the only player to have scored in a Champions League final, FA Cup final, UEFA Cup final and League Cup final?".equals(sentances)) {

            options = new String[]{"Steven Gerrard", "Robinho", "Sergio Agüero", "Wayne Rooney"};
            Collections.shuffle(Arrays.asList(options));
        }

        if ("Who is the only player to have scored a hat-trick in all four tiers of professional football in England, FA Cup, League Cup and at international level?".equals(sentances)) {

            options = new String[]{"Robert Earnshaw", "Christiano Ronaldo", "Eden Hazard", "Yaya Toure"};
            Collections.shuffle(Arrays.asList(options));
        }

        if ("Who is the only player to have scored in the Glasgow, Merseyside and Manchester derbies?".equals(sentances)) {

            options = new String[]{"Pep Guardiola", "Andrei Kanchelskis", "Jomo Sono", "David Silva"};
            Collections.shuffle(Arrays.asList(options));
        }


    }

    public int point(String sm, String index) {

        int point = 0;

        if ("Which is the national sport of Canada?".equals(sm) && "Lacrosse/Ice hockey".equals(index)) {

            point++;

        }

        if ("Archery is the national sport of which country?".equals(sm) && "Japan".equals(index)) {

            point++;

        }

        if ("______ has Cricket as its national sports.".equals(sm) && "Jamaica".equals(index)) {

            point++;

        }

        if ("_______ is the national sport of Turkey".equals(sm) && "Wrestling".equals(index)) {

            point++;

        }

        if ("When was the Commonwealth game started?".equals(sm) && "1930".equals(index)) {

            point++;

        }

        if ("Which was the host country in 1998 for Asian Games?".equals(sm) && "Thailand".equals(index)) {

            point++;

        }

        if ("Who is the only player to have won silverware at both Manchester United and Liverpool?".equals(sm) && "Michael Owen".equals(index)) {
            point++;

        }
        if ("Who is the only player to have scored in a Champions League final, FA Cup final, UEFA Cup final and League Cup final?".equals(sm) && "Steven Gerrard".equals(index)) {

            point++;

        }

        if ("Who is the only player to have scored a hat-trick in all four tiers of professional football in England, FA Cup, League Cup and at international level?".equals(sm) && "Robert Earnshaw".equals(index)) {

            point++;
        }

        if ("Who is the only player to have scored in the Glasgow, Merseyside and Manchester derbies?".equals(sm) && "Andrei Kanchelskis".equals(index)) {

            point++;

        }


        return point;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();


        Intent intent = new Intent(Sports.this, MainActivity.class);
      intent.putExtra("scores",total);
        Toast.makeText(Sports.this,""+total+" Questions right out of 10",Toast.LENGTH_LONG).show();
        startActivity(intent);

    }
}
