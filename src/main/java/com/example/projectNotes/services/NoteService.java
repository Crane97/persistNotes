package com.example.projectNotes.services;

import com.example.projectNotes.entities.Note;
import com.example.projectNotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public boolean comparedEstimatedDateAndCreationDate(LocalDate estimatedDate, LocalDate creationDate){
        //Must be true, estimatedDate must be later than creationDate
        return creationDate.isBefore(estimatedDate);
    }

    public List<Note> getCompletedNotes(){
        LocalDate now = LocalDate.now();

        List<Note> notes = noteRepository.findAll();
        List<Note> completedNotes = new ArrayList<>();

        for(Note note : notes){

            if(note.getCompletitionDate() != null){
                continue;
            }

            completedNotes.add(note);
        }

        return completedNotes;
    }

    public Note updatePriority(Note note, int priority){
        note.setPriority(priority);
        return updateNote(note);
    }

    public List<Note> searchTask(String description){
        return noteRepository.findByDescriptionContaining(description);
    }










}
