package com.example.map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button map;
    private Button map2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents(){
        this.map = findViewById(R.id.map);
        this.map2 = findViewById(R.id.map2);
    }

    public void onSendMaps(View view) {
        Uri.Builder builder= new Uri.Builder();
        builder.scheme("https").authority("www.google.com").appendPath("maps").appendPath("dir").appendPath("").appendQueryParameter("api", "1").appendQueryParameter("destination", 4.632339710 + "," + -74.065350);
        String url= builder.build().toString();
        Log.d("Directions", url);
        Intent intent= new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void onSendStreetMaps(View view) {
        Uri gmmIntentUri= Uri.parse("google.streetview:cbll=46.414382,10.013988");
        Intent mapIntent= new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}