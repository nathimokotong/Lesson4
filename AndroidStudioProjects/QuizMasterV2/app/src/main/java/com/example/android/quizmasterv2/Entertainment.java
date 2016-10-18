package com.example.android.quizmasterv2;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Codetribe on 2016/10/13.
 */
public class Entertainment extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    public String radiobtnString = "";
    public String line;
    int total;
    Dialog builder;
    int points;
    int itemscount;
    RadioButton radioBtn;
    String[] options;
    Boolean groupChck = false;
    String txt = "";
    int qcomplete = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_biology);
        builder = new Dialog(Entertainment.this);

        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);

        setTitle("Entertainment Questions");

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.LayoutID);

      //  linearLayout.setBackground(getResources().getDrawable(R.drawable.music));

        String[] values = new String[]{"In 2013, who resumed his career with his third and fourth albums The 20/20 Experience and The 20/20 Experience – 2 of 2, exploring new soul styles with 1960s and 1970s rock?"
                , "In May 2015, who dressesd up as George Michael to celebrate their 27th birthday and posted the snaps on Twitter?"
                , "Which singer appeared in the feature film, Battleship?"
                , "Whose 2013 world tour was called 'The Mrs Carter Show?"};

        Collections.shuffle(Arrays.asList(values));

        String q1, q2, q3, q4;

        q1 = values[0];
        q2 = values[1];
        q3 = values[2];
        q4 = values[3];


        String[] rearranged = new String[]{q1, q2, q3, q4};

        ListAdapter theAddptr = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rearranged);
        ListView theListView = (ListView) findViewById(R.id.listBioID);
        theListView.setAdapter(theAddptr);

        itemscount = values.length;


        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {


                qcomplete++;
                groupChck = false;
                adapterView.getChildAt(pos).setBackgroundColor(Color.GRAY);
                line = String.valueOf(adapterView.getItemAtPosition(pos));
                populate(line);
                dialog(options);
                adapterView.getChildAt(pos).setOnClickListener(null);
              //  adapterView, pos
            }

        });

    }

   // AdapterView adapterView, int pos,
    public void dialog(String[] arry)
    {

        builder.setContentView(R.layout.radiobutton);

        List<String> stringList = new ArrayList<String>();

        //Collections.shuffle(Arrays.asList(arry));

        for (int i = 0; i < 4; i++)
        {
            stringList.add(arry[i]);
        }

        final RadioGroup radioGroup = (RadioGroup) builder.findViewById(R.id.radiogroup);

        for (int i = 0; i < stringList.size(); i++)
        {
            RadioButton rb = new RadioButton(Entertainment.this); // dynamically creating RadioButton and adding to RadioGroup.
            rb.setText(stringList.get(i));
            radioGroup.addView(rb);

        }

        Button donebtn = new Button(Entertainment.this);
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
                if (txt.length() > 0) {

                    groupChck = true;
                }


            }
        });


        donebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                if (groupChck == true)
                {
                    points = point(line, txt);
                    total = total + points;
                    builder.dismiss();
                } else if (groupChck == false)
                {
                    Toast.makeText(Entertainment.this, "Please select answer ", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i)
    {

        radioBtn = (RadioButton) findViewById(i);
        radiobtnString = radioBtn.getText().toString();
        //  Toast.makeText(Sports.this,radiobtnString,Toast.LENGTH_LONG).show();

    }

    public void populate(String sentances)
    {

        if (("In 2013, who resumed his career with his third a" +
                "nd fourth albums The 20/20 Experience and The " +
                "20/20 Experience – 2 of 2, exploring new soul styles with 1960s and " +
                "1970s rock?").equals(sentances))
        {

            options = new String[]{"Sisco", "Super Furry ", "Justin Timberlake", "Elton John"};
            Collections.shuffle(Arrays.asList(options));

        }

        if ("In May 2015, who dressesd up as George Michael to celebrate their 27th birthday and posted the snaps on Twitter?".equals(sentances))
        {

            options = new String[]{"Adele", "Super Furry ", "James Brown", "Pink"};
            Collections.shuffle(Arrays.asList(options));
        }

        if ("Which singer appeared in the feature film, Battleship?".equals(sentances))
        {

            options = new String[]{"Rihanna", "Meatloaf", "Matt Cardle", "Katy Perry"};
            Collections.shuffle(Arrays.asList(options));
        }

        if ("Whose 2013 world tour was called 'The Mrs Carter Show?".equals(sentances))
        {

            options = new String[]{"Beyonce", "Bonnie Tyler", "Kim Holiday", "Shania Twain"};
            Collections.shuffle(Arrays.asList(options));
        }


    }

    public int point(String sm, String index)
    {

        int point = 0;

        if (("In 2013, who resumed his career with his third and fourth" +
                " albums The 20/20 Experience and The 20/20 Experience – 2 of 2," +
                " exploring new soul styles with 1960s and 1970s rock?").equals(sm) && "Justin Timberlake".equals(index))
        {
            point++;

        }

        if ("In May 2015, who dressesd up as George Michael to celebrate their 27th birthday and posted the snaps on Twitter?".equals(sm) && "Adele".equals(index))
        {
            point++;
        }

        if (("Which singer appeared in the feature film, Battleship?").equals(sm) && "Rihanna".equals(index))
        {
            point++;

        }

        if ("Whose 2013 world tour was called 'The Mrs Carter Show?".equals(sm) && "Beyonce".equals(index))
        {

            point++;
        }

        return point;
    }


    @Override
    public void onBackPressed()
    {


        if (qcomplete < 4)
        {


            int rem = itemscount - qcomplete;

            Toast.makeText(Entertainment.this, "Please answer the remaining " + rem + " question(s)", Toast.LENGTH_LONG).show();
        }
        else
        {

         //   Toast.makeText(Entertainment.this, "" + total + " Questions right out of " + itemscount, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Entertainment.this, MainActivity.class);
            intent.putExtra("scores", total);

            SharedPreferences preferences = getSharedPreferences("score",0);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("entscore", String.valueOf(total)+"/"+String.valueOf(itemscount));
            editor.commit();

            startActivity(intent);
        }

    }
}