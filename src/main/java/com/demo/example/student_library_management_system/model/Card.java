package com.demo.example.student_library_management_system.model;


import com.demo.example.student_library_management_system.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "card")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "card_status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @Column(name = "create_date", nullable = false)
    @CreationTimestamp // it automatically adds date and time when card is created
    private Date createDate;

    @Column(name = "update_date", nullable = false)
    @UpdateTimestamp // it automatically updates date and time when card is updated
    private Date updateDate;
}
