package com.example.android.lesson4;

import android.widget.ImageView;

/**
 * Created by Codetribe on 2016/10/31.
 */
public class Word {

    private static final int NO_IMAGE = -1;
    private String mDefault;
    private String mMiwok;
    private int imageResID = NO_IMAGE;


    //we can have two constractors

    //_____________________first
    public Word(String d , String m)
    {
        mDefault = d;
        mMiwok = m;

    }
    //_____________________secound
    public Word(String d , String m, int i)
    {
        mDefault = d;
        mMiwok = m;
        imageResID = i;
    }

    public String getmDefault()
    {
        return mDefault;
    }

    public String getmMiwok()
    {
        return mMiwok;
    }

    public int getImageResource() { return imageResID;}

    public boolean hasimage()
    {
      return imageResID != NO_IMAGE;
    }
}


