package com.travel.travelmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class LocationDescriptionActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    ImageView location_image, close_button;
    TextView location_country, location_place, star_rating;
    AppCompatButton covid_info, travel_restriction;
    ScrollView travel_scroll, covid_scroll;

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

        // Clicked on covid info or travel restriction
        covid_info = findViewById(R.id.covid_info);
        travel_restriction = findViewById(R.id.travel_restriction);
        travel_scroll = findViewById(R.id.scrollview_1);
        covid_scroll = findViewById(R.id.scrollview_2);
        // click covid info
        covid_info.setOnClickListener(v -> {
            travel_restriction.setBackgroundResource(R.drawable.flag_transparent);
            travel_restriction.setTextColor(Color.parseColor("#BFBFBF"));
            covid_info.setBackgroundResource(R.drawable.two_section_interchangable_effect);
            covid_info.setTextColor(Color.parseColor("#EB5757"));
            covid_scroll.scrollTo(0,0);
            covid_scroll.setVisibility(View.VISIBLE);
            travel_scroll.setVisibility(View.INVISIBLE);
        });
        // click travel restriction
        travel_restriction.setOnClickListener(v -> {
            covid_info.setBackgroundResource(R.drawable.flag_transparent);
            covid_info.setTextColor(Color.parseColor("#BFBFBF"));
            travel_restriction.setBackgroundResource(R.drawable.two_section_interchangable_effect);
            travel_restriction.setTextColor(Color.parseColor("#EB5757"));
            travel_scroll.scrollTo(0,0);
            travel_scroll.setVisibility(View.VISIBLE);
            covid_scroll.setVisibility(View.INVISIBLE);
        });
    }
}