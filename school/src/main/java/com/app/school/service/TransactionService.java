package com.app.school.service;

import com.app.school.model.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransactions();

    Transaction getTransactionById(Long id);

    Transaction saveTransaction(Transaction transaction);

    void deleteTransaction(Long id);
}
