package com.chandan.easynotes123.convert;


import com.chandan.easynotes123.Model.Note;
import com.chandan.easynotes123.resource.NoteResource;

import java.util.List;

public interface NoteConvertService {

    NoteResource convert(Note note);

    List<NoteResource> convertNoteList(List<Note> noteByTitle);
}
