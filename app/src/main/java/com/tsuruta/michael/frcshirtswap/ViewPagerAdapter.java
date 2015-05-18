package com.tsuruta.michael.frcshirtswap;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter
{
    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created
    int Location1;

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb, int Location)
    {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
        this.Location1 = Location;
    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position)
    {
        if (Location1 == 0) //If it is the SmartTrade tab layout.
        {
            if(position == 0) // If the position is 0 we are returning the First tab
            {
                Tab1 tab1 = new Tab1();
                return tab1;
            }
            else             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
            {
                Tab2 tab2 = new Tab2();
                return tab2;
            }
        }
        else if (Location1 == 1) //If it is the account tab layout.
        {
            if(position == 0) // If the position is 0 we are returning the First tab
            {
                TabLogin TabLogin = new TabLogin();
                return TabLogin;
            }
            else             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
            {
                TabRegister TabRegister = new TabRegister();
                return TabRegister;
            }
        }
        else //This will never be called.
        {
            return null;
        }
    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position)
    {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount()
    {
        return NumbOfTabs;
    }
}