package com.example.krunal.project3_a1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Boolean attractions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 =  findViewById(R.id.button_1);
        button2 =  findViewById(R.id.button_2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Lookup Attractions", Toast.LENGTH_SHORT).show();
                attractions = true;
                startAnotherApp();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Lookup Restaurants", Toast.LENGTH_SHORT).show();
                attractions = false;
                startAnotherApp();
            }
        });
    }
    protected void startAnotherApp(){
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.example.project3_a2");
        if(intent == null) return;
        if(attractions){
            intent.putExtra("type", true);
        } else
            intent.putExtra("type", false);
        startActivity(intent);
    }
}
