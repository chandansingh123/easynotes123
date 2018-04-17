package com.chandan.easynotes123.Service;

import com.chandan.easynotes123.Model.Note;
import com.chandan.easynotes123.dto.NoteDto;

import java.util.List;

public interface NoteService {
    List <Note> findAllNotes();

     Note addNennote(NoteDto noteDto);


    Note noteUpdate(NoteDto noteDto, Long noteId);

    List<Note> getNoteByTitle(String title);

    List<Note> getNoteByUserId(Long userId);

    //List<Note> getNoteByUserId(Long userId);
}
