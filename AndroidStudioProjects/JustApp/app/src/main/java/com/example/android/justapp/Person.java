package com.example.android.justapp;

/**
 * Created by Codetribe on 2016/09/08.
 */
public class Person {

    private String name;
    private String surname;
    private int age;
    private String race;

public Person()
    {


    }

public Person(String name,String surname,int age,String race)
{

    this.name = name;
    this.surname = surname;
    this.age = age;
    this.race = race;

}


    public void setName(String nm)
    {

        this.name = nm;

    }

    public void setSurname(String nm)
    {

        this.surname = nm;

    }

    public void setAge(int ag)
    {

        this.age = ag;

    }

    public void setRace(String rc)
    {

        this.race = rc;
    }


    public String getName()
    {

        return this.name;

    }

    public String getSurname()
    {


        return this.surname;
    }


    public int getAge()
    {

        return this.age;
    }

    public String getRace()
    {

        return this.race;
    }

}

