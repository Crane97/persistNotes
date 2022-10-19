package com.example.projectNotes.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "NoteFields")
@Table(name = "NoteFields")
@Getter
@Setter
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

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
    private String linkType;

    @Column
    private String mention;

    @Column
    private String profile;

    @Column
    private int priority;


}
