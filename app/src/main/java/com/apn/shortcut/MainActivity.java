package com.apn.shortcut;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Try to launch the APN settings activity
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$ApnSettingsActivity");
        
        PackageManager pm = getPackageManager();
        if (pm.resolveActivity(intent, 0) != null) {
            startActivity(intent);
            finish(); // Close the app after launching the settings
        } else {
            // If the specific activity is not found, try the general settings
            Intent settingsIntent = new Intent(android.provider.Settings.ACTION_SETTINGS);
            if (pm.resolveActivity(settingsIntent, 0) != null) {
                startActivity(settingsIntent);
                finish();
            } else {
                Toast.makeText(this, "Settings app not found", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}