package com.travel.travelmate;

import static com.travel.travelmate.Const.Name;
import static com.travel.travelmate.Const.recentsDataList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.travel.travelmate.adapter.RecentsAdapter;
import com.travel.travelmate.model.RecentsData;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickInterface{

    AppCompatButton btnProfile;
    AppCompatTextView tvWelcome;
    SharedPreferences sharedPreferences;
    String name;
    RecyclerView recentRecycler;
    RecentsAdapter recentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvWelcome = findViewById(R.id.tvName);
        sharedPreferences = getSharedPreferences(Const.SHAREDPREFERENCE, MODE_PRIVATE);
        name = sharedPreferences.getString(Name, "0");
        tvWelcome.setText("Welcome " + name + ",");

        // Create recent recycler view
        // get recentsDataList from Const.java
        setRecentRecycler(recentsDataList);

        // Go to profile
        btnProfile = findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(v -> {
            Intent nav_to_profile = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(nav_to_profile);
        });
    }

    private void setRecentRecycler(List<RecentsData> recentsDataList)
    {
        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList, this);
        recentRecycler.setAdapter(recentsAdapter);
    }

    @Override
    public void onItemClick(int position) {
        // Log.d("Tag", String.valueOf(recentsDataList.get(position).getPlaceName()));
        Intent nav_to_location_description = new Intent(MainActivity.this, LocationDescriptionActivity.class);

        // Set location information
        sharedPreferences = getSharedPreferences(Const.SHAREDPREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("countryName", recentsDataList.get(position).getCountryName());
        editor.putString("placeName", recentsDataList.get(position).getPlaceName());
        editor.putString("price", recentsDataList.get(position).getPrice());
        editor.putFloat("star_rating", recentsDataList.get(position).getStarRating());
        editor.putInt("imageUrl", recentsDataList.get(position).getImageUrl());
        editor.apply();

        startActivity(nav_to_location_description);
    }
}