package com.afra.assessment.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.afra.assessment.Adapter.ItemsAdapter;
import com.afra.assessment.MainActivity;
import com.afra.assessment.Models.SellModel;
import com.afra.assessment.Models.TransactionModel;
import com.afra.assessment.R;
import com.afra.assessment.VM.TransactionViewModel;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;


public class SellFragment extends Fragment implements ItemsAdapter.OnItemClickListener {

    TextInputEditText productname;
    AlertDialog mBox;
    TextView date;
    TextView time;
    TextInputEditText inputprice;
    TextInputEditText unit;
    TextInputEditText quantity;
    TextView total;
    Button savebtn;
    private TransactionViewModel transactionViewModel;
    MainActivity mactivity;
    int sumtotal = 0;



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
        mactivity = (MainActivity) getActivity();
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sell, container, false);
        mactivity.showBackbtn("Sell");
        productname = view.findViewById(R.id.productname);
        date = view.findViewById(R.id.date);
        time = view.findViewById(R.id.time);
        inputprice = view.findViewById(R.id.price);
        unit = view.findViewById(R.id.unit);
        quantity = view.findViewById(R.id.quantity);
        total = view.findViewById(R.id.total);
        savebtn = view.findViewById(R.id.savebtn);
        transactionViewModel =new TransactionViewModel();
        textWatcher();
         productname.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                selectItemDialog();
             }
         });

         savebtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 TransactionModel transactionModel = new TransactionModel("22-08-21","15:13",productname.getText().toString(),inputprice.getText().toString(),unit.getText().toString(),quantity.getText().toString(),total.getText().toString(),"sell");
                transactionViewModel.makeTransactions(transactionModel);
                mactivity.getFragmentManager().popBackStack();
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
        productname.setText(itemname);
        inputprice.setText(price);
        Log.d("selecteditem",itemname);
    }
    public void textWatcher(){
        quantity.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                  sumtotal = Integer.parseInt(s.toString())*Integer.parseInt(inputprice.getText().toString());

                  total.setText(String.valueOf(sumtotal));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}