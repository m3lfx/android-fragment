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
import com.example.infobook.adapters.ViewPagerAdapterWonders;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WondersActivity extends AppCompatActivity {
    private TabLayout tabLayoutWonders;
    private ViewPager2 viewPagerWonders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wonders);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tabLayoutWonders = findViewById(R.id.tabLayoutWonders);
        viewPagerWonders = findViewById(R.id.viewPagerWonders);

        ViewPagerAdapterWonders adapter = new ViewPagerAdapterWonders(getSupportFragmentManager(),getLifecycle());

        viewPagerWonders.setAdapter(adapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayoutWonders, viewPagerWonders
                , true, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                if (position == 0)
                {
                    tab.setText("Taj Mahal");
                }

            }
        });

        tabLayoutMediator.attach();
    }
    
}