package com.alphacodes.librarymanagementsystem.Model;

import jakarta.persistence.*;

@Entity
public class ReservationManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long remreID;

    @ManyToOne
    @JoinColumn(name = "remlID")
    private Librarian librarian;

    private String status;
}

