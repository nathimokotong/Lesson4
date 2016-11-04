package com.example.android.lesson4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Codetribe on 2016/10/31.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context,ArrayList<Word> words) {

        super(context,0,  words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //check if the existing view is being reused, or else inflate the view
        View listView = convertView;
        if(listView == null)
        {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.listview_lay_custom,parent,false);
        }

        Word wrd = getItem(position);
        TextView defualt = (TextView) listView.findViewById(R.id.default_textview);
        defualt.setText(wrd.getmDefault());


        TextView miWok = (TextView) listView.findViewById(R.id.miwork_textview);
        miWok.setText(wrd.getmMiwok());

        ImageView imView = (ImageView) listView.findViewById(R.id.imageView);
        imView.setImageResource(wrd.getImageResource());
        return listView;

    }
}
