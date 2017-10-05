package com.example.brent.moreintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callHome(View view) {
        Uri number = Uri.parse("tel:5555551234");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

        if(callIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(callIntent);
        }
    }

    public void launchWebsite(View view) {
        Uri webpage = Uri.parse("http://tutorialsbyibrent.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }

    public void shareText(View view) {
        String message = "Hey, check out these cool videos";
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);
        sendIntent.setType("text/plain");

        Intent chooser = Intent.createChooser(sendIntent, "Share with friends:");
        if(sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }
}
