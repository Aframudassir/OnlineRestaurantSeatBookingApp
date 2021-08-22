package com.afra.assessment.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.afra.assessment.Adapter.DashboardAdapter;
import com.afra.assessment.MainActivity;
import com.afra.assessment.Models.TransactionModel;
import com.afra.assessment.R;
import com.afra.assessment.VM.TransactionViewModel;

import java.util.List;


public class HomeFragment extends Fragment {

    private TransactionViewModel transactionViewModel;
    RecyclerView mrecyclerview;
    DashboardAdapter dashboardAdapter;
    MainActivity mactivity;
    Button sell;







    public HomeFragment() {
        // Required empty public constructor
    }




    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mactivity = (MainActivity) getActivity();
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view =  inflater.inflate(R.layout.fragment_home, container, false);
       dashboardAdapter = new DashboardAdapter(requireContext());
       mrecyclerview = view.findViewById(R.id.transactionrecyclerView);
       sell = view.findViewById(R.id.sellbutton);


       transactionViewModel = new TransactionViewModel();
       transactionViewModel.getTransactions().observe(getViewLifecycleOwner(), new Observer<List<TransactionModel>>() {
           @Override
           public void onChanged(List<TransactionModel> transactionModels) {
                dashboardAdapter.transactionlist.submitList(transactionModels);
                mrecyclerview.setAdapter(dashboardAdapter);
           }
       });
       clickListeners();
       return view;
    }
     public void clickListeners(){
        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mactivity.movetofrag(new SellFragment());
            }
        });
     }


}