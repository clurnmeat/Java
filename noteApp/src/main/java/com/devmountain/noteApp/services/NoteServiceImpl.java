package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.NoteDto;
import com.devmountain.noteApp.entities.Note;
import com.devmountain.noteApp.entities.User;
import com.devmountain.noteApp.repositories.NoteRepository;
import com.devmountain.noteApp.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.*;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;
import static java.util.Collections.EMPTY_LIST;


@Service
public class NoteServiceImpl {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;


     @Transactional
     public void addNote(NoteDto noteDto, Long userId){
         List<String> response = new ArrayList<>();
         Optional<User> userOptional = userRepository.findById(userId);
         Note note = new Note(noteDto);
         userOptional.ifPresent(note::setUser);
         noteRepository.saveAndFlush(note);
         response.add("Note Added Successfully");

     }
    @Transactional
     public List<NoteDto> getAllNotesByUserId(Long userId){
         Optional<User> userOptional = userRepository.findById(userId);
         if(userOptional.isPresent()) {
             List<Note> noteList = noteRepository.findAllByUserEquals(userOptional.get());
             return noteList.stream().map(note -> new NoteDto(note)).collect(Collectors.toList());
         }
         return Collections.emptyList();
     }

    @Transactional
    public void removeNoteById(Long noteId) {
        Optional<Note> noteOptional = noteRepository.findById(noteId);
        noteOptional.ifPresent(note -> noteRepository.delete(note));
    }
    @Transactional
    public void updateNoteById(NoteDto noteDto){
        Optional<Note> noteOptional = noteRepository.findById(noteDto.getId());
        noteOptional.ifPresent(note -> {
            note.setBody(noteDto.getBody());
            noteRepository.saveAndFlush(note);
        });

    }

    @Transactional
    public Optional<NoteDto> getNoteById(Long noteId){
         Optional<Note> noteOptional = noteRepository.findById(noteId);
         if(noteOptional.isPresent()){
             return Optional.of(new NoteDto(noteOptional.get()));
         }
         return Optional.empty();
    }
}
