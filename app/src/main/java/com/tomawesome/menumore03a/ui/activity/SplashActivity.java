package com.tomawesome.menumore03a.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tomawesome.menumore03a.R;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.tomawesome.menumore03a.ui.activity.user.UserLoginActivity;
import com.tomawesome.menumore03a.ui.activity.location.EnableLocationActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 2000; // 2 seconds
    private static final int PERMISSION_REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkGPSPermission();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    private void checkGPSPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
        } else {
            openUserLoginActivity();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openUserLoginActivity();
            } else {
                openEnableLocationActivity();
            }
        }
    }

    private void openUserLoginActivity() {
        Intent intent = new Intent(SplashActivity.this, UserLoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void openEnableLocationActivity() {
        Intent intent = new Intent(SplashActivity.this, com.tomawesome.menumore03a.ui.activity.location.EnableLocationActivity.class);
        startActivity(intent);
        finish();
    }

}