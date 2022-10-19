package com.example.projectNotes.repository;

import com.example.projectNotes.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    Note findByDescription(String description);
}
