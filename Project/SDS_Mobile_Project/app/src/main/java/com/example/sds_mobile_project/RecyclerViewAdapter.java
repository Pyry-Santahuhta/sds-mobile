package com.example.sds_mobile_project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sds_mobile_project.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Recipe> recipes;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    RecyclerViewAdapter(Context context, ArrayList<Recipe> data, ItemClickListener itemClickListener) {
        this.mInflater = LayoutInflater.from(context);
        this.recipes = data;
        this.mClickListener = itemClickListener;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view, mClickListener);
    }

    // binds the data to the TextView in each row
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Recipe recipe = recipes.get(position);
        holder.recipeTextView.setText("\u2022 " + recipe.getTitle());

        holder.deleteButton.setOnClickListener(v -> {
        recipes.remove(recipes.get(position));
        notifyItemRemoved(position);
       });
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return recipes.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageButton deleteButton;
        TextView recipeTextView;
        ItemClickListener itemClickListener;
        ViewHolder(View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            recipeTextView = itemView.findViewById(R.id.textView);
            this.itemClickListener = itemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onItemClick(getAdapterPosition());
        }
    }


    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {

        void onItemClick(int adapterPosition);
    }

}
