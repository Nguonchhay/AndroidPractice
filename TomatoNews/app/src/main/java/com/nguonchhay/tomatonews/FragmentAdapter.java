package com.nguonchhay.tomatonews;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1: return new SportFragment();
            case 2: return new HealthFragment();
            case 3: return new EntertainmentFragment();
            case 4: return new TechnologyFragment();
        }
        return new HomeFragment();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
