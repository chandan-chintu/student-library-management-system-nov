package com.demo.example.student_library_management_system.model;

import com.demo.example.student_library_management_system.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int pages;

    @Column(name = "publisher_name", nullable = false)
    private String publisherName;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Column(name = "is_available", nullable = false)
    private boolean isAvailable;
}
