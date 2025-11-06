package com.apntest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "APNTestApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "MainActivity created");

        // Find the button and set click listener
        Button openApnButton = findViewById(R.id.open_apn_button);
        openApnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApnSettings();
            }
        });

        // Automatically open APN settings when the app starts
        openApnSettings();
    }

    private void openApnSettings() {
        try {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setClassName("com.android.settings", "com.android.settings.Settings$ApnSettingsActivity");
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            
            // Check if the activity exists before starting
            PackageManager pm = getPackageManager();
            if (intent.resolveActivity(pm) != null) {
                startActivity(intent);
            } else {
                // Fallback to general settings if APN settings are not available
                Intent fallbackIntent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                startActivity(fallbackIntent);
                Toast.makeText(this, "APN Settings not found, opening general settings", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Log.e(TAG, "Error opening APN settings: " + e.getMessage());
            Toast.makeText(this, "Error opening APN settings: " + e.getMessage(), Toast.LENGTH_LONG).show();
            
            // Fallback to general settings
            try {
                Intent fallbackIntent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                startActivity(fallbackIntent);
            } catch (Exception fallbackException) {
                Toast.makeText(this, "Unable to open settings", Toast.LENGTH_LONG).show();
            }
        }
    }
}