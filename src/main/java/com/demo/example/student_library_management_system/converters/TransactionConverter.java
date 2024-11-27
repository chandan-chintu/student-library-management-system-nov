package com.demo.example.student_library_management_system.converters;

import com.demo.example.student_library_management_system.model.Transaction;
import com.demo.example.student_library_management_system.requestdto.TransactionRequestDto;

public class TransactionConverter {

    // converts TransactionRequestDto into Transaction class

    public static Transaction convertTransactionRequestDtoIntoTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction =  Transaction.builder()
                .transactionStatus(transactionRequestDto.getTransactionStatus())
                .fine(transactionRequestDto.getFine())
                .isIssueOrReturn(transactionRequestDto.isIssueOrReturn())
                .dueDate(transactionRequestDto.getDueDate())
                .build();
        return transaction;
    }
}
