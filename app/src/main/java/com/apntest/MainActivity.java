package com.example.apnlauncher;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "MainActivity created");
        
        // Initialize UI components
        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.openApnButton);
        
        // Set text
        textView.setText("APN Settings");
        button.setText("Open APN Settings");
        
        // Open APN Settings automatically when the app starts
        openApnSettings();
        
        // Set button click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApnSettings();
            }
        });
    }
    
    private void openApnSettings() {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.android.settings", 
                    "com.android.settings.Settings$ApnSettingsActivity"));
            startActivity(intent);
        } catch (Exception e) {
            Log.e(TAG, "Failed to open APN Settings", e);
        }
    }
}