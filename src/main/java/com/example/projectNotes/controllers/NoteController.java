package com.example.projectNotes.controllers;

import com.example.projectNotes.entities.Note;
import com.example.projectNotes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api/noteFields")
public class NoteController {

    @Autowired
    public NoteService noteService;

    @GetMapping
    public Note getNote(Long id){
        return noteService.getNote(id);
    }

    @GetMapping(path = "/all")
    public List<Note> getAllNotes(){
        return new ArrayList<>();
    }

    @PostMapping(path = "/add")
    public Note addNote(@RequestBody Note note){
        return noteService.createNote(note);
    }

    @PostMapping(path = "/update")
    public Note updateNote(@RequestBody Note note){
        return noteService.updateNote(note);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteNote(@PathVariable(value = "id") Long id){
        noteService.deleteNote(id);
    }
}
