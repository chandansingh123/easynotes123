package com.chandan.easynotes123.convert;

import com.chandan.easynotes123.Model.Note;
import com.chandan.easynotes123.resource.NoteResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteConvertServiceImpl implements NoteConvertService{
    @Override
    public NoteResource convert(Note note) {

        return NoteResource.builder()
                .content(note.getContent())
                .createdDate(note.getCreatedAt())
                .noteId(note.getId())
                .status(note.getStatus())
                .title(note.getTitle())
                .build();
    }

    @Override
    public List<NoteResource> convertNoteList(List<Note> noteByTitle) {
        List<NoteResource> noteResources= new ArrayList<>();
        for (Note note:noteByTitle){
            noteResources.add(convert(note));
        }
        return noteResources;
    }
}
