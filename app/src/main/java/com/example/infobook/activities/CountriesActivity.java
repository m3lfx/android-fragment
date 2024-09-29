package com.example.infobook.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.infobook.R;
import com.example.infobook.adapters.ViewerPagerAdapterCountries;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CountriesActivity extends AppCompatActivity {
    private TabLayout tabLayoutCountries;
    private ViewPager2 viewPagerCountries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_countries);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tabLayoutCountries = findViewById(R.id.tabLayoutUnitedKingdom);
        viewPagerCountries = findViewById(R.id.viewPagerUnitedKingdom);

        ViewerPagerAdapterCountries adapter = new ViewerPagerAdapterCountries(getSupportFragmentManager(),getLifecycle());

        viewPagerCountries.setAdapter(adapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayoutCountries, viewPagerCountries
                ,true , true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position)
                {
                    case 0:
                        tab.setText("United Kingdom");
                        break;
                    case 1:
                        tab.setText("France");
                        break;
                    case 2:
                        tab.setText("Italy");
                }

            }
        });

        tabLayoutMediator.attach();

    }
}