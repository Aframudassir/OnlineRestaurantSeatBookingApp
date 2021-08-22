package com.afra.assessment.VM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.afra.assessment.DataRepo.Repository;
import com.afra.assessment.Models.TransactionModel;

import java.util.List;

public class TransactionViewModel extends ViewModel{

    private MutableLiveData<List<TransactionModel>> transactionList ;

    private Repository repository;

    public MutableLiveData<List<TransactionModel>> getTransactions(){
        repository = new Repository();
        transactionList = repository.getTransactionModel();
        return transactionList;
    }

    public MutableLiveData<List<TransactionModel>> makeTransactions(TransactionModel transactionModel){
        repository = new Repository();
        transactionList = repository.makeTransactionModel(transactionModel);
        return transactionList;
    }
}
