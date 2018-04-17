package com.chandan.easynotes123.controller;

import com.chandan.easynotes123.Model.Note;
import com.chandan.easynotes123.Repository.NoteRepository;
import com.chandan.easynotes123.Service.NoteService;
import com.chandan.easynotes123.convert.NoteConvertService;
import com.chandan.easynotes123.dto.NoteDto;
import com.chandan.easynotes123.resource.NoteResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    private final NoteConvertService noteConvertService;
    private final NoteService noteService;
    private final NoteRepository noteRepository;

    public NoteController(NoteConvertService noteConvertService, NoteService noteService, NoteRepository noteRepository) {
        this.noteConvertService = noteConvertService;
        this.noteService = noteService;
        this.noteRepository = noteRepository;
    }


    @GetMapping(value = "/notes")
    public List<Note> findAll(){
       return noteService.findAllNotes();

    }

    @PostMapping(value = "/notes")
    public NoteResource addNewNote(@RequestBody NoteDto noteDto){
     return noteConvertService.convert(noteService.addNennote(noteDto));
    }

    /*@PostMapping("/notes/{id}")
    public void deleteNote(@PathVariable(value = "id") Long noteId){
        noteService.deleteId(noteId);
    }*/

    @PutMapping("/notes/{id}")
    public NoteResource updateNote(@PathVariable(value = "id")Long noteId,
                                   @RequestBody NoteDto noteDto){
        return noteConvertService.convert(noteService.noteUpdate(noteDto,noteId));
    }

    @GetMapping(value = "/notes/title")
    public List<NoteResource> getNoteByTitle(@RequestParam(value = "title") String title){
        return noteConvertService.convertNoteList(noteService.getNoteByTitle(title));
    }

   @GetMapping(value = "/notes/user/{id}")
    public List<NoteResource> getNoteByUserId(@PathVariable(value = "id")Long userId){
        return noteConvertService.convertNoteList(noteService.getNoteByUserId(userId));
    }
}
