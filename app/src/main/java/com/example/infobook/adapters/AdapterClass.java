package com.example.infobook.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infobook.ModelClass;
import com.example.infobook.R;
import com.example.infobook.activities.CountriesActivity;
import com.example.infobook.activities.LeadersActivity;
import com.example.infobook.activities.MuseumsActivity;
import com.example.infobook.activities.WondersActivity;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.CardViewHolder>{
    private ArrayList<ModelClass> modelList;
    private Context context;

    public AdapterClass(ArrayList<ModelClass> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design, parent, false);

        return new CardViewHolder(view);
    }
    @SuppressLint("DiscouragedApi")
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, @SuppressLint("RecyclerView") int position) {

        ModelClass model = modelList.get(position);
        holder.textViewSplash.setText(model.getCategoryName());
        holder.imageViewSplash.setImageResource(context.getResources()
                .getIdentifier(model.getImageName(),"drawable",context.getPackageName()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == 0)
                {
                    Intent intent = new Intent(context, CountriesActivity.class);
                    context.startActivity(intent);
                }
                if (position == 1)
                {
                    Intent intent = new Intent(context, LeadersActivity.class);
                    context.startActivity(intent);
                }
                if (position == 2)
                {
                    Intent intent = new Intent(context, MuseumsActivity.class);
                    context.startActivity(intent);
                }
                if (position == 3)
                {
                    Intent intent = new Intent(context, WondersActivity.class);
                    context.startActivity(intent);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewSplash;
        private TextView textViewSplash;
        private CardView cardView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewSplash = itemView.findViewById(R.id.imageViewSplash);
            textViewSplash = itemView.findViewById(R.id.textViewSplash);
            cardView = itemView.findViewById(R.id.cardView);


        }
    }
}
