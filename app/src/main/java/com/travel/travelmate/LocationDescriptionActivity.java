package com.travel.travelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationDescriptionActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    ImageView location_image, close_button;
    TextView location_country, location_place, star_rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_more_detail);
        sharedPreferences = getSharedPreferences(Const.SHAREDPREFERENCE, MODE_PRIVATE);

        // Set location description background based on clicked item
        location_image = findViewById(R.id.backgroundImage);
        location_image.setImageResource(sharedPreferences.getInt("imageUrl", 0));

        // Set location and place
        location_country = findViewById(R.id.location_country);
        location_country.setText(sharedPreferences.getString("countryName", ""));
        location_place = findViewById(R.id.location_place);
        location_place.setText(sharedPreferences.getString("placeName", ""));

        // set star
        star_rating = findViewById(R.id.desc_star);
        star_rating.setText(String.valueOf(sharedPreferences.getFloat("star_rating", 0.0f)) + "/5.0");

        // Close the location description
        close_button = findViewById(R.id.close_button);
        close_button.setOnClickListener(v -> {
            finish();
        });
    }
}