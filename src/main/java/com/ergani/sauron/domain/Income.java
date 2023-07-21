package com.ergani.sauron.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "id")
    private Resident resident;

    private Double amount;

    private Date date;
}
