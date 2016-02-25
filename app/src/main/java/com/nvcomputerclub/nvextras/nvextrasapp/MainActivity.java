package com.nvcomputerclub.nvextras.nvextrasapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.content.Intent;

public class MainActivity extends ActionBarActivity {

    //Declare class fields
    ListView listview;
    Button button;
    public static final String  EXTRA_POSITION = "com.tomas.computerclubapp.message";
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Create activity and set content to activity_main xml file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //construct listview and button objects
        listview = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.button);

        //set array with String values of list
        String[] values = getApplicationContext().getResources().getStringArray(R.array.club_names);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
        //setList with strings from values with adapter
        listview.setAdapter(adapter);


        //Item in ListView clicked
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //Call method to change class
                changeClass(position);
            }
        });
    }

    //Used to switch to detailActivity
    private void changeClass(int position)
    {
        //initialize intent to change classes
        i = new Intent(MainActivity.this, DetailActivity.class);
        //pass along extra information- position integer- to next activity
        i.putExtra(EXTRA_POSITION, position);
        //change activities
        startActivity(i);
    }


    //Menu code that can be implemented later-leave for now
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
