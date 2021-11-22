package com.example.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    String[] pastas;
    String[] pastaNumbers;
    String[] pastaDescriptions;

    public ItemAdapter(Context context, String[] p, String[] n, String[] d){
        pastas = p;
        pastaNumbers = n;
        pastaDescriptions = d;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return pastas.length;
    }

    @Override
    public Object getItem(int position) {
        return pastas[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.pasta_detail, null);
        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView numberTextView = view.findViewById(R.id.numberTextView);
        TextView descriptionTextView = view.findViewById(R.id.descriptionTextView);

        titleTextView.setText(pastas[position]);
        numberTextView.setText(pastaNumbers[position]);
        descriptionTextView.setText( pastaDescriptions[position]);

        return view;
    }
}
