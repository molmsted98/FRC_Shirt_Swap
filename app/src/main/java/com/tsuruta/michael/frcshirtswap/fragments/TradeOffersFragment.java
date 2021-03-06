package com.tsuruta.michael.frcshirtswap.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tsuruta.michael.frcshirtswap.tradeInfo.MyAdapter;
import com.tsuruta.michael.frcshirtswap.R;

public class TradeOffersFragment extends Fragment
{
    public TradeOffersFragment()
    {
    }

    //Set up the list of offers for the user.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_tradeoffers, container, false);
        RecyclerView recList = (RecyclerView)v.findViewById(R.id.cardList);

        recList.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        MyAdapter ca = new MyAdapter(30);
        recList.setAdapter(ca);

        return v;
    }
}
