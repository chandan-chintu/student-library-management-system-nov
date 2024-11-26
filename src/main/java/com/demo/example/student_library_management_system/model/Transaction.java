package com.demo.example.student_library_management_system.model;

import com.demo.example.student_library_management_system.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "transaction_status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Column(name = "transaction_date", nullable = false)
    @CreationTimestamp
    private Date transactionDate;

    @Column(nullable = false)
    private double fine;

    @Column(name = "is_issue_or_return", nullable = false)
    private boolean isIssueOrReturn;

    @Column(name = "due_date")
    private String dueDate;
}
