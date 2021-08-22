package com.afra.assessment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.afra.assessment.Models.SellModel;
import com.afra.assessment.R;

import org.jetbrains.annotations.NotNull;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    Context adapterContext;
    OnItemClickListener itemClick;




    public ItemsAdapter(Context context,OnItemClickListener itemClick){
        this.adapterContext = context;
        this.itemClick = itemClick;

    }

    DiffUtil.ItemCallback<SellModel> diffUtil = new DiffUtil.ItemCallback<SellModel>() {


        @Override
        public boolean areItemsTheSame(@NonNull @NotNull SellModel oldItem, @NonNull @NotNull SellModel newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull @NotNull SellModel oldItem, @NonNull @NotNull SellModel newItem) {
            return false;
        }
    };

    public AsyncListDiffer itemslist = new AsyncListDiffer(this,diffUtil);

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_dialogitems,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemsAdapter.ViewHolder holder, int position) {

        SellModel data = (SellModel) itemslist.getCurrentList().get(position);

        holder.itemname.setText(data.getItemname());
        holder.itemname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onItemClick(data.getItemname(), data.getPrice());
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemslist.getCurrentList().size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemname;


        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            itemname = itemView.findViewById(R.id.itemname);

        }

    }

    public interface OnItemClickListener {
        void onItemClick(String itemname,int price);
    }
}

