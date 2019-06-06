package com.u3100289.uc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // ArrayList for Buttons
    ArrayList<Button> buttonList = new ArrayList<Button>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Buttons
        Button canButton = (Button) findViewById(R.id.canvasButton);
        Button emailButton = (Button) findViewById(R.id.emailButton);
        Button mapButton = (Button) findViewById(R.id.mapButton);
        Button timeTableButton = (Button) findViewById(R.id.timetableButton);

        // Add to Arraylist
        buttonList.add(canButton);
        buttonList.add(emailButton);
        buttonList.add(mapButton);
        buttonList.add(timeTableButton);


    }

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


    public void toWeb(View view) {
        Intent intent = new Intent(this, WebView_Activity.class);
        // Button ID to webview
        if(view.getId() == buttonList.get(0).getId())
        {
            intent.putExtra("url", "https://uclearn.canberra.edu.au/");
            intent.putExtra("title", "UC Canvas");
        }

        if(view.getId() == buttonList.get(1).getId())
        {
            intent.putExtra("url", "https://outlook.office365.com/owa/?realm=uni.canberra.edu.au&vd=www");
            intent.putExtra("title", "Email");
        }

        if(view.getId() == buttonList.get(3).getId())
        {
            intent.putExtra("url", "https://www.canberra.edu.au/myuc-u/enrolments-and-timetables/uc-class-allocation-system");
        }
        startActivity(intent);
    }

    public void toMap (View view)
    {
        Intent intent = new Intent(this, MapView_Activity.class);
        startActivity(intent);
    }



}
