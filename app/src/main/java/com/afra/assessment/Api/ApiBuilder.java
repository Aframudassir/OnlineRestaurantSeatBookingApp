package com.afra.assessment.Api;

import com.afra.assessment.Models.TransactionModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiBuilder {

    @GET("/api/getTransactionList")
    Call<List<TransactionModel>> getTransactions();

    @GET("/api/GetTotalPurchaseAndSell")
    Call<List<TransactionModel>> getPurchseAndSell();

    @POST("/api/createTransaction")
    Call<List<TransactionModel>> makeTransaction();

    @PUT("/api/updateTransaction")
    Call<List<TransactionModel>> updateTransaction();
}
