package com.u3100289.uc;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import android.widget.ImageView;
import java.util.concurrent.ThreadLocalRandom;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // ArrayList for Buttons
    ArrayList<Button> buttonList = new ArrayList<Button>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        ImageView imageView = findViewById(R.id.imageView);


        Random ran = new Random();
        int randomInt = ran.nextInt(8);
        if(randomInt == 0){randomInt = randomInt+=ran.nextInt(7);}

        String tmp = "a" + randomInt;
        System.out.println("FILE" + tmp);

        Resources res = getResources();
        int resourceId = res.getIdentifier(
               tmp , "drawable", getPackageName() );
        imageView.setImageResource(resourceId);

        // Buttons
        Button canButton = (Button) findViewById(R.id.canvasButton);
        Button emailButton = (Button) findViewById(R.id.emailButton);
        Button mapButton = (Button) findViewById(R.id.mapButton);
        Button timeTableButton = (Button) findViewById(R.id.timetableButton);
        Button examButton = (Button) findViewById(R.id.examButton);
        Button homeButton = (Button) findViewById(R.id.homeButton);



        // Add to Arraylist
        buttonList.add(canButton);
        buttonList.add(emailButton);
        buttonList.add(mapButton);
        buttonList.add(timeTableButton);
        buttonList.add(examButton);
        buttonList.add(homeButton);
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
            intent.putExtra("url", "https://www.canberra.edu.au/content/myuc/home/course/timetable.html");
            intent.putExtra("title", "Timetable");
        }

        if(view.getId() == buttonList.get(4).getId())
        {
            intent.putExtra("url", "https://www.canberra.edu.au/content/myuc/home/course/exams/exam-information.html");
            intent.putExtra("title", "Exam Timetable");
        }

        if(view.getId() == buttonList.get(5).getId())
        {
           intent.putExtra("url", "https://www.canberra.edu.au/content/myuc/home.html");
           intent.putExtra("title", "Home");
        }
        startActivity(intent);
    }

    public void toMap (View view)
    {
        Intent intent = new Intent(this, MapView_Activity.class);
        startActivity(intent);
    }

    // Open External
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
