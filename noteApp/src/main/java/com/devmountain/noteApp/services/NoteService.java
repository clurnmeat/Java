package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.NoteDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    @Transactional
    void addNote(NoteDto noteDto, Long userId);

    @Transactional
    List<NoteDto> getAllNotesByUserId(Long userId);

    @Transactional
    void removeNoteById(Long noteId);

    @Transactional
    void updateNoteById(NoteDto noteDto);

    @Transactional
    Optional<NoteDto> getNoteById(Long noteId);
}
