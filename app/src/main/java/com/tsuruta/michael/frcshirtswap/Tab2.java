package com.tsuruta.michael.frcshirtswap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab2 extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_2,container,false);
        Button mAddShirt = (Button) v.findViewById(R.id.btnAddShirt2);
        mAddShirt.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(final View v) //Does stuff when it's clicked.
    {
        switch (v.getId())
        {
            case R.id.btnAddShirt1:

                break;
        }
    }
}