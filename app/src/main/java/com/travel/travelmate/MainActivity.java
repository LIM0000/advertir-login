package com.travel.travelmate;

import static com.travel.travelmate.Const.Name;

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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("Agra", "India", "$200", R.drawable.india_location, 3.5f));
        recentsDataList.add(new RecentsData("Great Wall of China", "China", "$300", R.drawable.china_location, 4.5f));
        recentsDataList.add(new RecentsData("Marina Sand Bay", "Singapore", "$400", R.drawable.singapore_location, 4f));
        recentsDataList.add(new RecentsData("KLCC", "Malaysia", "$500", R.drawable.malaysia_location, 5f));
        recentsDataList.add(new RecentsData("Bangkok", "Thailand", "$600", R.drawable.thailand_location, 5f));
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
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);
    }
}