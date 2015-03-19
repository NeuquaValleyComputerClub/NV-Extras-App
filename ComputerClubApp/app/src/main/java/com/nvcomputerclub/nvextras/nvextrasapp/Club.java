package com.nvcomputerclub.nvextras.nvextrasapp;



import android.app.Application;
import android.content.Context;
import android.graphics.Picture;
import android.widget.TextView;

public class Club extends Application{

    //Class fields
    private String title;
    private String info;
    //Used for default constructor
    private static Context context;
    private Picture picture;



    //Needed to use context object
    @Override
    public void onCreate()
    {
        super.onCreate();
        context = this;

    }

    public static Context getContext()
    {
        return context;
    }

    //Default Constructor-initializes to Club_1 String for title field and Club_1_Detail for info field
    public Club(Context context)
    {

        title = context.getResources().getString(R.string.club_1);
        info = context.getResources().getString(R.string.club_1_detail);

    }

    //Main constructor
    public Club(int position, String[] titleArray, String[] detailsArray)
    {
        //Precondition: Arrays are initialized before being passed to constructor; int position within array
        //Postcondition: Create Club object according to position of titleArray and detailsArray
        //clubsList = context.getResources().getStringArray(R.array.club_names);
        //clubDetails = context.getResources().getStringArray(R.array.club_details);
        //this.title = clubsList[position];
        //this.info = clubDetails[position];

        this.title = titleArray[position];
        this.info = detailsArray[position];


    }

    //return title
    public String getTitle()    {   return title;   }
    //return info
    public String getInfo()    {   return info;   }

    //Sets the text of a textview Object with title field
    public void setTitle(TextView titleView)
    {
        titleView.setText(title);
    }

    //Sets the text of a textview Object with info field
    public void setInfo(TextView infoView)
    {
        infoView.setText(info);
    }

    //Used to set up app detail screen: can set both textviews needed to be set in the DetailActivity
    public void setAll(TextView titleView, TextView infoView)
    {
        titleView.setText(title);
        infoView.setText(info);
    }

    //returns state of object
    public String toString()
    {
        return "Title: " + title + " Info: " + info;
    }
}
