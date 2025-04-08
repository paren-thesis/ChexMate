package com.nerds.clout.gen.chexmate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nerds.clout.gen.chexmate.fragments.TrendsFragment;
import com.nerds.clout.gen.chexmate.fragments.VibesFragment;
import com.nerds.clout.gen.chexmate.fragments.TeaFragment;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private ImageView profileIcon;
    private ImageView searchIcon;
    private ImageView settingsIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeViews();
        setupBottomNavigation();
        setupToolbar();
        
        // Start with Vibes fragment as default
        loadFragment(new VibesFragment());
    }

    private void initializeViews() {
        bottomNavigation = findViewById(R.id.bottomNavigation);
        profileIcon = findViewById(R.id.profileIcon);
        searchIcon = findViewById(R.id.searchIcon);
        settingsIcon = findViewById(R.id.settingsIcon);
    }

    private void setupBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_trends) {
                loadFragment(new TrendsFragment());
                return true;
            } else if (itemId == R.id.nav_vibes) {
                loadFragment(new VibesFragment());
                return true;
            } else if (itemId == R.id.nav_tea) {
                loadFragment(new TeaFragment());
                return true;
            }
            return false;
        });

        // Set Vibes as selected by default
        bottomNavigation.setSelectedItemId(R.id.nav_vibes);
    }

    private void setupToolbar() {
        profileIcon.setOnClickListener(v -> {
            // TODO: Navigate to user profile
            Intent intent = new Intent(HomeActivity.this, ViewUserProfileActivity.class);
            startActivity(intent);
        });

        searchIcon.setOnClickListener(v -> {
            // TODO: Show search dialog or navigate to search screen
        });

        settingsIcon.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }
}