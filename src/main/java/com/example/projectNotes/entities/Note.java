package com.example.projectNotes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "NoteFields")
@Table(name = "NoteFields")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return priority == note.priority && Objects.equals(id, note.id) && Objects.equals(description, note.description) && Objects.equals(text, note.text) && Objects.equals(creationDate, note.creationDate) && Objects.equals(estimatedDate, note.estimatedDate) && Objects.equals(completitionDate, note.completitionDate) && Objects.equals(link, note.link) && Objects.equals(linkType, note.linkType) && Objects.equals(mention, note.mention) && Objects.equals(profile, note.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, text, creationDate, estimatedDate, completitionDate, link, linkType, mention, profile, priority);
    }
}
