package com.afra.assessment.DataRepo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.afra.assessment.Models.TransactionModel;
import com.afra.assessment.Utils.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    public MutableLiveData<List<TransactionModel>> getTransactionModel(){
        final MutableLiveData<List<TransactionModel>> transactionList = new MutableLiveData<>();
        RetrofitInstance.apiBuilder().getTransactions().enqueue(new Callback<List<TransactionModel>>() {
            @Override
            public void onResponse(Call<List<TransactionModel>> call, Response<List<TransactionModel>> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    Log.d("response",response.body().toString());
                    transactionList.postValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<List<TransactionModel>> call, Throwable t) {
                Log.d("response",t.getLocalizedMessage());

            }
        });
        return transactionList;
    }
}
