package com.example.projectNotes.services;

import com.example.projectNotes.entities.Note;
import com.example.projectNotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NoteService {

    @Autowired
    public NoteRepository noteRepository;

    public Note getNote(Long id){

        return noteRepository.findById(id).orElse(null);

    }

    public Note createNote(Note note){

        if(!comparedEstimatedDateAndCreationDate(note.getEstimatedDate(), note.getCreationDate())){
            return new Note();
        }

        note = setTypeLink(note.getLink(), note);
        note.setProfile(getProfileLink(note.getMention()));

        return noteRepository.save(note);
    }

    public Note updateNote(Note note){
        return noteRepository.save(note);
    }

    public void deleteNote(Long id){
        noteRepository.delete(getNote(id));
    }

    public List<Note> getCurrentNote(){
        LocalDate currentDate = LocalDate.now();

        List<Note> allNotes = noteRepository.findAll();
        List<Note> result = new ArrayList<>();

        for(Note no : allNotes){
            if(no.getCompletitionDate() == null){
                result.add(no);
            }
        }

        return result;
    }

    public List<Note> getFutureNotes(){
        LocalDate currentDate = LocalDate.now();

        List<Note> allNotes = noteRepository.findAll();
        List<Note> result = new ArrayList<>();

        for(Note no : allNotes){
            if(no.getEstimatedDate().isAfter(currentDate)){
                result.add(no);
            }
        }

        return result;
    }

    public boolean comparedEstimatedDateAndCreationDate(LocalDate estimatedDate, LocalDate creationDate){

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


    public String getProfileLink(String mentions){

        String[] parts = mentions.split(",");
        String links = "";

        for(String name: parts){

            if(name.contains("@")){
                links = links.concat("https://twitter.com/" + name.substring(1) + ",");
            }
            else{
                links = links.concat("-,");
            }
        }

        return links.substring(0, links.length() - 1);
    }

    public List<Note> searchNoteByPeople(Note note, String people){
        return noteRepository.findByMentionContaining(people);
    }

    public Note setTypeLink(String link, Note note){

        Pattern patternEmail = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher matchEmail = patternEmail.matcher(link);

        //Setting email
        if(matchEmail.matches()){
            note.setLinkType("EMAIL");
            return note;
        }
        if(link.matches("(.*)youtube.com/watch?(.*)")){
            note.setLinkType("YOUTUBE");
            return note;
        }
        if(link.matches("(.*).com(.*)")){
            note.setLinkType("WEBPAGE");
            return note;
        }
        if(link.matches("(.*).pdf")){
            note.setLinkType("PDF");
            return note;
        }

        return note;
    }
}
