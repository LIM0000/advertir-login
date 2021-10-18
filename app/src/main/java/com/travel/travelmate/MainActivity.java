package com.travel.travelmate;

import static com.travel.travelmate.Const.Name;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btnProfile;
    AppCompatTextView tvWelcome;
    SharedPreferences sharedPreferences;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvWelcome = findViewById(R.id.tvName);
        sharedPreferences = getSharedPreferences(Const.SHAREDPREFERENCE, MODE_PRIVATE);
        name = sharedPreferences.getString(Name, "0");
        tvWelcome.setText("Welcome, " + name);


        // Go to profile
        btnProfile = findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(v -> {
            Intent nav_to_profile = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(nav_to_profile);
        });
    }
}