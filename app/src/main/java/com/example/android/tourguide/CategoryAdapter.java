package com.example.android.tourguide;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that provides the layout for
 * list item data taken from {@link Info} objects.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    /**
     * Create a {@link CategoryAdapter} object.
     *
     * @param fm stands for the fragment manager that keeps the state in the adapter when being swiped.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Returns the {@link Fragment} that is displayed for the given position.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SightsFragment();
        } else if (position == 1) {
            return new ActivitiesFragment();
        } else if (position == 2) {
            return new FoodFragment();
        } else if (position == 3) {
            return new LodgingFragment();
        } else {
            return new EventsFragment();
        }
    }

    /**
     * Return the total number of fragment pages.
     */
    @Override
    public int getCount() {
        return 5;
    }

    /**
     * Provides the titles in the {@link TabLayout} for each fragment.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Sights";
        } else if (position == 1) {
            return "Activities";
        } else if (position == 2) {
            return "Food";
        } else if (position == 3) {
            return "Lodging";
        } else {
            return "Events";
        }
    }
}
