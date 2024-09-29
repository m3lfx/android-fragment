package com.example.infobook.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.infobook.fragments.FragmentFrance;
import com.example.infobook.fragments.FragmentItaly;
import com.example.infobook.fragments.FragmentUnitedKingdom;

public class ViewerPagerAdapterCountries extends FragmentStateAdapter {
    public ViewerPagerAdapterCountries(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        switch (position)
        {
            case 0:
                fragment = FragmentUnitedKingdom.newInstance();
                break;
            case 1:
                fragment = FragmentFrance.newInstance();
                break;
            case 2:
                fragment = FragmentItaly.newInstance();
                break;
            default:
                return null;
        }

        return fragment;
    }


    @Override
    public int getItemCount() {
        return 3;
    }
}
