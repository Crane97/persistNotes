package com.example.projectNotes.services;

import com.example.projectNotes.entities.Note;
import com.example.projectNotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    public NoteRepository noteRepository;

    public Note getNote(Long id){

        return noteRepository.findById(id).get();
    }

    public Note createNote(Note note){
        return noteRepository.save(note);
    }

    public Note updateNote(Note note){
        return noteRepository.save(note);
    }

    public void deleteNote(Long id){
        noteRepository.delete(getNote(id));
    }
}
