package com.tsuruta.michael.frcshirtswap;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Tab1 extends Fragment implements View.OnClickListener
{
    Button mAddShirt;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        //Add the tab to the fragment.
        View v =inflater.inflate(R.layout.tab_1,container,false);
        mAddShirt = (Button) v.findViewById(R.id.btnAddShirt1);
        mAddShirt.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(final View v) //Add another shirt tab for wants.
    {
        switch (v.getId())
        {
            case R.id.btnAddShirt1:

                break;
        }
    }
}