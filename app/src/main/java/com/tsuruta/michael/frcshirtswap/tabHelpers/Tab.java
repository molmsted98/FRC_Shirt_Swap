package com.tsuruta.michael.frcshirtswap.tabHelpers;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tsuruta.michael.frcshirtswap.R;

/**
 * Created by student on 9/15/15.
 */
public class Tab extends Fragment implements View.OnClickListener
{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        //Add the tab to the fragment.
        View v = inflater.inflate(R.layout.tab_2,container,false);
        return v;
    }

    @Override
    public void onClick(final View v) //Add another shirt for haves.
    {
        switch (v.getId())
        {
            case R.id.btnAddShirt2:

                break;
        }
    }
}
