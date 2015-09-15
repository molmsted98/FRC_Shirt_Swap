package com.tsuruta.michael.frcshirtswap.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.parse.ParseUser;
import com.tsuruta.michael.frcshirtswap.R;

public class MainActivityFragment extends Fragment implements View.OnClickListener
{
    public MainActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        //Brings up the mainscreen view.
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        //Add variables for the buttons, and set click listeners.
        if (v != null)
        {
            Button mButton = (Button) v.findViewById(R.id.smartTrade);
            Button mTradeOffers = (Button) v.findViewById(R.id.tradeOffers);
            Button mLogout = (Button) v.findViewById(R.id.btnLogout);
            if (mButton != null)
            {
                mButton.setOnClickListener(this);
            }
            if (mTradeOffers != null)
            {
                mTradeOffers.setOnClickListener(this);
            }
            if (mLogout != null)
            {
                mLogout.setOnClickListener(this);
            }
        }
        return v;
    }

    @Override
    public void onClick(final View v)
    {
       switch (v.getId())
       {
           case R.id.smartTrade:
               //Swap mainscreen fragment with SmartTrade fragment.
               FragmentTransaction ft = getFragmentManager().beginTransaction();
               ft.replace(R.id.placeholder, new SmartTradeFragment());
               ft.addToBackStack(null);
               ft.commit();
               break;
           case R.id.tradeOffers:
               //Swaps mainscreen fragment with TradeOffers fragment.
               FragmentTransaction t = getFragmentManager().beginTransaction();
               t.replace(R.id.placeholder, new TradeOffersFragment());
               t.addToBackStack(null);
               t.commit();
               break;
           case R.id.btnLogout:
               //Logs the user out
               ParseUser.logOut();
               ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
               FragmentTransaction a = getFragmentManager().beginTransaction();
               a.replace(R.id.placeholder, new AccountFragment());
               a.commit();
       }
    }
}
