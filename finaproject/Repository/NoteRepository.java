package com.chandan.easynotes123.Repository;

import com.chandan.easynotes123.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {


    @Query("select n from Note n where n.title = :title")
    List<Note> getNoteByTitle(@Param("title") String title);

   // List<Note> getNoteByUserId(Long userId);
    @Query("select n from Note n where n.user.id = :id")
    List<Note> getNoteByUserId(@Param("id") Long userId);
}
