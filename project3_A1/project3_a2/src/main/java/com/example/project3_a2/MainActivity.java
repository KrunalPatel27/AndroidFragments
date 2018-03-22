package com.example.project3_a2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //enforceCallingPermission("com.example.krunal.project3_a1","sdfds");

        //int code = checkSelfPermission("com.example.krunal.project3_a1");
        /*
        Intent intent = getIntent();
        if (intent != null) {
            int permissionCode = this.checkCallingPermission ("com.example.krunal.project3_a1");
            if (PackageManager.PERMISSION_GRANTED == permissionCode) {
            }
            else{
                //finish();
            }
        }
        */
        setContentView(R.layout.activity_main);
    }
}
