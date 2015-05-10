package com.tsuruta.michael.frcshirtswap;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 5/5/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.TradeViewHolder>
{
    private List<TradeInfo> tradeList;

    public MyAdapter(int size)
    {
        this.tradeList = createList(size);
    }

    @Override
    public int getItemCount()
    {
        return tradeList.size();
    }

    @Override
    public void onBindViewHolder(TradeViewHolder contactViewHolder, int i) {
        TradeInfo ci = tradeList.get(i);
        contactViewHolder.vName.setText(ci.name);
        contactViewHolder.vSize.setText(ci.size);
        contactViewHolder.vColor.setText(ci.color);
        contactViewHolder.vTitle.setText(ci.name + " " + ci.size);
    }

    @Override
    public TradeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new TradeViewHolder(itemView);
    }

    public static class TradeViewHolder extends RecyclerView.ViewHolder {
        protected TextView vName;
        protected TextView vSize;
        protected TextView vColor;
        protected TextView vTitle;

        public TradeViewHolder(View v)
        {
            super(v);
            vName = (TextView)v.findViewById(R.id.txtName);
            vSize = (TextView)v.findViewById(R.id.txtSize);
            vColor = (TextView)v.findViewById(R.id.txtColor);
            vTitle = (TextView)v.findViewById(R.id.title);
        }
    }

    private List createList(int size) {

        List result = new ArrayList();
        for (int i=1; i <= size; i++) {
            TradeInfo ci = new TradeInfo();
            ci.name = TradeInfo.NAME_PREFIX + i;
            ci.color = TradeInfo.COLOR_PREFIX + i;
            ci.size = TradeInfo.SIZE_PREFIX + i + "@test.com";

            result.add(ci);

        }

        return result;
    }
}
