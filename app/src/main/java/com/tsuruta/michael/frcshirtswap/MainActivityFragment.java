package com.tsuruta.michael.frcshirtswap;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
            if (mButton != null)
            {
                mButton.setOnClickListener(this);
            }
            if (mTradeOffers != null)
            {
                mTradeOffers.setOnClickListener(this);
            }
        }
        return v;
    }

    @Override
    public void onClick(final View v) //Does stuff when it's clicked.
    {
       switch (v.getId())
       {
           case R.id.smartTrade:
               //Swap mainscreen fragment with SmartTrade fragment.
               FragmentTransaction ft = getFragmentManager().beginTransaction();
               ft.replace(R.id.placeholder, new SmartTradeFragment());
               ft.commit();
               break;
           case R.id.tradeOffers:
               FragmentTransaction t = getFragmentManager().beginTransaction();
               t.replace(R.id.placeholder, new TradeOffersFragment());
               t.commit();
               break;


               //Swap mainscreen fragment with TradeOffers fragment.
            //   FragmentTransaction aa = getFragmentManager().beginTransaction();
           //    aa.replace(R.id.placeholder, new TradeOffersFragment());
            //   aa.commit();
            //   break;
       }
    }
}
