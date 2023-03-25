package com.example.palace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HomeItem> list = new ArrayList<>();
    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        HomeItem item = list.get(position);
        holder.onbind(item);
    }

    public void setDonationList(Context context, ArrayList<HomeItem> list){
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView place;
        ImageView image;
        TextView category;
        TextView space;
        TextView people;

        public ViewHolder(View itemView) {
            super(itemView);
            place = (TextView) itemView.findViewById(R.id.tv_place);
            image = (ImageView) itemView.findViewById(R.id.iv_prof);
            category = (TextView) itemView.findViewById(R.id.tv_category);
            space = (TextView) itemView.findViewById(R.id.tv_space);
            people = (TextView) itemView.findViewById(R.id.tv_cnt);
        }

        public void onbind(HomeItem item) {
            place.setText(item.getPlace());
            category.setText(item.getCategory());
            space.setText(item.getSpace());
            people.setText(item.getMax());
            Glide.with(context).load(item.getImage()).override(200,130).into(image);
        }
    }
}
