package com.guy.class22a_and_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;

public class Activity_Lottie extends AppCompatActivity {

    private MaterialButton lottie_BTN_start;
    private LottieAnimationView lottie_SPC_egg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);

        lottie_BTN_start = findViewById(R.id.lottie_BTN_start);
        lottie_SPC_egg = findViewById(R.id.lottie_SPC_egg);

        lottie_BTN_start.setOnClickListener(view -> startAnimation());
    }

    private void startAnimation() {
        lottie_SPC_egg.pauseAnimation();
    }
}