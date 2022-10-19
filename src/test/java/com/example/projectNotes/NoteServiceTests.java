package com.example.projectNotes;

import com.example.projectNotes.entities.Note;
import com.example.projectNotes.services.NoteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class NoteServiceTests {

    @Autowired
    private NoteService noteService;

    @Test
    public void createNote_returnsNote(){
        //given
        Note note = new Note(null, "descr","text", LocalDate.now().minusYears(2),LocalDate.now().plusYears(2), null,"www.youtube.com/watch?/fkdjgsjak", null, "Miguel,@jorge",null,3);

        //when
        Note res = noteService.createNote(note);

        //then
        Assertions.assertNotNull(res.getId());
    }

    @Test
    public void createNote_dontSaveNote(){
        //given
        Note note = new Note(null, "descr","text", LocalDate.now().plusYears(2),LocalDate.now().plusYears(1), null,"www.youtube.com/watch?/fkdjgsjak", null, "Miguel,@jorge",null,3);
        Note expected = new Note();
        //when
        Note res = noteService.createNote(note);

        //then
        Assertions.assertEquals(res, expected);
    }

}
