package com.example.krunal.project3_a1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    static final int MY_PERMISSION_ATTRACTIONS = 0;
    static final int MY_PERMISSION_RESTAURANTS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 =  findViewById(R.id.button_1);
        button2 =  findViewById(R.id.button_2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.project3_a1)
                        == PackageManager.PERMISSION_GRANTED){
                    broadcastIntent("com.example.krunal.project3.attractions");
                }
                else{
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.project3_a1}, MainActivity.MY_PERMISSION_ATTRACTIONS) ;
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.project3_a1)
                        == PackageManager.PERMISSION_GRANTED){
                    broadcastIntent("com.example.krunal.project3.restaurants");
                }
                else{
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.project3_a1}, MainActivity.MY_PERMISSION_RESTAURANTS) ;
                }
            }
        });
    }
    protected void broadcastIntent(String intentEvent){
        Intent intent = new Intent();
        intent.setAction(intentEvent);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

                // If request is cancelled, the result arrays are empty.
                if(grantResults.length >0)
                {
                    if ( grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        // permission was granted, yay! Do the
                        switch (requestCode) {
                            case MainActivity.MY_PERMISSION_ATTRACTIONS: {
                                broadcastIntent("com.example.krunal.project3.attractions");
                            }
                            case MainActivity.MY_PERMISSION_RESTAURANTS: {
                                broadcastIntent("com.example.krunal.project3.restaurants");
                            }
                        }
                    } else {
                        // permission denied, boo! Disable the
                        Toast.makeText(MainActivity.this, "denied permission", Toast.LENGTH_SHORT).show();
                    }

                return;
                }

    }
}

