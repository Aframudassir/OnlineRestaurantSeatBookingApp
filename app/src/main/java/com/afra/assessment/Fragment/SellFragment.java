package com.afra.assessment.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afra.assessment.Adapter.ItemsAdapter;
import com.afra.assessment.Models.SellModel;
import com.afra.assessment.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SellFragment extends Fragment implements ItemsAdapter.OnItemClickListener {

    TextInputEditText productname;
    AlertDialog mBox;


    public SellFragment() {
        // Required empty public constructor
    }


    public static SellFragment newInstance(String param1, String param2) {
        SellFragment fragment = new SellFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sell, container, false);
        productname = view.findViewById(R.id.productname);
         productname.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                selectItemDialog();
             }
         });

        return view;
    }


    public void selectItemDialog(){

        View mView = LayoutInflater.from(requireContext()).inflate(R.layout.layout_dialog,null,false);
        MaterialAlertDialogBuilder mDialog = new MaterialAlertDialogBuilder(requireContext());

        RecyclerView mrecyclerview = mView.findViewById(R.id.itemsrecyclerView);
        ItemsAdapter itemsAdapter = new ItemsAdapter(requireContext(),this::onItemClick);

        ArrayList<SellModel> sellModels = new ArrayList<>(Arrays.asList(new SellModel("Pasta",200),new SellModel("Pizza",500),new SellModel("Tomato",20)));
        itemsAdapter.itemslist.submitList(sellModels);
        mrecyclerview.setAdapter(itemsAdapter);
        mDialog.setView(mView);
        mDialog.setCancelable(true);


        mBox = mDialog.show();
    }

    @Override
    public void onItemClick(String itemname, int price) {

        mBox.dismiss();
        Log.d("selecteditem",itemname);
    }
}