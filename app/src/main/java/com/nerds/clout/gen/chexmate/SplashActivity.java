package com.nerds.clout.gen.chexmate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Navigate to the next screen after delay
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // TODO: Add logic to check if user is logged in
            // For now, we'll navigate to the onboarding screen
            Intent intent = new Intent(SplashActivity.this, OnboardingActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_DELAY);
    }
}