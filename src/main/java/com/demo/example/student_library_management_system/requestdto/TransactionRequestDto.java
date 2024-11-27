package com.demo.example.student_library_management_system.requestdto;

import com.demo.example.student_library_management_system.enums.TransactionStatus;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class TransactionRequestDto {

    private TransactionStatus transactionStatus;
    private double fine;
    private boolean isIssueOrReturn;
    private String dueDate;
    private int bookId;
    private int cardId;
}
