package com.example.projectNotes.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class NoteFields {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @Column
    private String description;
    @Column
    private String text;
    @Column
    private LocalDate creationDate;
    @Column
    private LocalDate estimatedDate;
    @Column
    private LocalDate completitionDate;
    @Column
    private String link;
    @Column
    private String mentions;
    @Column
    private int priority;




}
