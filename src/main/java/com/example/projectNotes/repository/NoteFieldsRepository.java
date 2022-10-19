package com.example.projectNotes.repository;

import com.example.projectNotes.entities.NoteFields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteFieldsRepository extends JpaRepository<NoteFields, Integer> {

}
