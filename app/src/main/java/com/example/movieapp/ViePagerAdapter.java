package com.example.movieapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.movieapp.Fragments.Movies;
import com.example.movieapp.Fragments.TVSeries;

public class ViePagerAdapter extends FragmentPagerAdapter {
 /*   public ViePagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }*/

    public ViePagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TVSeries();
        } else {
            return new Movies();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "TV SERIES";
        } else {
            return "MOVIE";

        }

    }
}
