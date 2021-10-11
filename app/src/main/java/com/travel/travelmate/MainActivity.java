package com.travel.travelmate;

import static com.travel.travelmate.Const.Name;
import static com.travel.travelmate.Const.UserId;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    AppCompatTextView tvWelcome;
    SharedPreferences sharedPreferences;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvWelcome = findViewById(R.id.tvWelcome);
        sharedPreferences = getSharedPreferences(Const.SHAREDPREFERENCE, MODE_PRIVATE);
        name = sharedPreferences.getString(Name, "0");
        tvWelcome.setText("Welcome, " + name);
    }
}