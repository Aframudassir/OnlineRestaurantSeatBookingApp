package com.afra.assessment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.afra.assessment.Models.TransactionModel;
import com.afra.assessment.R;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {

        Context adapterContext;





        public DashboardAdapter(Context context){
            this.adapterContext = context;

        }

        DiffUtil.ItemCallback<TransactionModel> diffUtil = new DiffUtil.ItemCallback<TransactionModel>() {

            @Override
            public boolean areItemsTheSame(@NonNull @org.jetbrains.annotations.NotNull TransactionModel oldItem, @NonNull @org.jetbrains.annotations.NotNull TransactionModel newItem) {
                return oldItem.getName().equals(newItem.getName());
            }

            @Override
            public boolean areContentsTheSame(@NonNull @org.jetbrains.annotations.NotNull TransactionModel oldItem, @NonNull @org.jetbrains.annotations.NotNull TransactionModel newItem) {
                return oldItem.getName().equals(newItem.getName());
            }
        };

        public AsyncListDiffer transactionlist = new AsyncListDiffer(this,diffUtil);

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DashboardAdapter.ViewHolder holder, int position) {

        TransactionModel data = (TransactionModel) transactionlist.getCurrentList().get(position);


        if (data.getTypeOfTransaction().equals("sell")){
            holder.sell.setVisibility(View.VISIBLE);
            holder.sell.setText(data.getTotalPrice());
            holder.purchase.setVisibility(View.INVISIBLE);
        }else{
            holder.purchase.setVisibility(View.VISIBLE);
            holder.purchase.setText(data.getTotalPrice());
            holder.sell.setVisibility(View.INVISIBLE);
        }



    }

    @Override
    public int getItemCount() {
        return transactionlist.getCurrentList().size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView purchase;
            public TextView sell;
            public TextView date;
            public TextView quantity;

            public ViewHolder(@NonNull @NotNull View itemView) {
                super(itemView);

                purchase = itemView.findViewById(R.id.purchase);
                sell = itemView.findViewById(R.id.sell);
                date = itemView.findViewById(R.id.timeanddate);
                quantity = itemView.findViewById(R.id.quantity);

            }
        }
    }

