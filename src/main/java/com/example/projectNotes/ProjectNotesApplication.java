package com.example.projectNotes;

import com.example.projectNotes.entities.Note;
import com.example.projectNotes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectNotesApplication.class, args);
	}

}
