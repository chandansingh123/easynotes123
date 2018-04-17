package com.chandan.easynotes123.Service;

import com.chandan.easynotes123.Model.Note;
import com.chandan.easynotes123.Model.Status;
import com.chandan.easynotes123.Repository.NoteRepository;
import com.chandan.easynotes123.dto.NoteDto;
import com.chandan.easynotes123.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List <Note> findAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note addNennote(NoteDto noteDto) {
       Note note=new Note();
       note.setContent(noteDto.getContent());
       note.setTitle(noteDto.getTitle());
       note.setStatus(Status.ACTIVE);
       return noteRepository.save(note);
    }

    @Override
    public Note noteUpdate(NoteDto noteDto, Long noteId) {
        Note note= noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFound("Note", "id", noteId));
        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        //Note updateNote = noteRepository.save(note);
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getNoteByTitle(String title) {
        return noteRepository.getNoteByTitle(title);
    }

    /*@Override
    public List<Note> getNoteByUserId(Long userId) {
        return null;
    }
*/
    @Override
    public List<Note> getNoteByUserId(Long userId) {
        return noteRepository.getNoteByUserId(userId);

    }
}
