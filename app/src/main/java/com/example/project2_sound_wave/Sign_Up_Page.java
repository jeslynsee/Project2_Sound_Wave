package com.example.project2_sound_wave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.project2_sound_wave.databinding.ActivitySignUpPageBinding;

public class Sign_Up_Page extends AppCompatActivity {
    ActivitySignUpPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //making sure sign up button listener is working
        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Sign_Up_Page.this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();
                Intent intent = MainActivity.mainActivityIntentFactory(getApplicationContext(), 0);
                startActivity(intent);
            }
        });

        // if user clicks this, it will redirect them to Login page
        binding.loginRedirectTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Login_Page.loginIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

    }

    // created intent here, so we can start up this activity from button click in Main
    static Intent signUpIntentFactory(Context context) {
        Intent intent = new Intent(context, Sign_Up_Page.class);
        return intent;
    }
}