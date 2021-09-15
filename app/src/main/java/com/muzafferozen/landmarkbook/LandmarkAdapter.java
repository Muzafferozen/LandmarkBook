package com.muzafferozen.landmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muzafferozen.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.landmarkHolder>{

    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public landmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding =  RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new landmarkHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull landmarkHolder holder, int position) {
        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
                intent.putExtra("landmark",landmarkArrayList.get(position));

                Singleton singleton = Singleton.getInstance();
                singleton.setSentLandmark(landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }

    public class landmarkHolder extends  RecyclerView.ViewHolder{
       private RecyclerRowBinding binding;
        public landmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

}
