package com.travel.travelmate;

import static com.travel.travelmate.Const.Name;
import static com.travel.travelmate.Const.Mobile;
import static com.travel.travelmate.Const.Email;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    AppCompatButton btnLogout;
    AppCompatTextView tvName, tvMobile, tvEmail;
    ImageView btnGoBack;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        sharedPreferences = getSharedPreferences(Const.SHAREDPREFERENCE, MODE_PRIVATE);

        // Display information
        tvName = findViewById(R.id.tvName);
        tvMobile = findViewById(R.id.tvMobile);
        tvEmail = findViewById(R.id.tvEmail);
        tvName.setText("Username: " + sharedPreferences.getString(Name, "0"));
        tvMobile.setText("Mobile Number: " + sharedPreferences.getString(Mobile, "0"));
        tvEmail.setText("Email: " + sharedPreferences.getString(Email, "0"));


        // Logout
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> {
            // clear the "sharedPreferences" object
            sharedPreferences.edit().clear().commit();
            Intent logout = new Intent(ProfileActivity.this, LoginActivity.class);
            Toast.makeText(ProfileActivity.this, "Logout successfully", Toast.LENGTH_SHORT).show();
            startActivity(logout);
            finish();
        });

        // Close button
        btnGoBack = findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(v -> {
            finish();
        });
    }
}