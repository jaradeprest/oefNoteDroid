package iam.deprest.oefnotedroid.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface NoteDAO {

    @Insert
    void insertNote(Note newNote);

    @Delete
    void deleteNote(Note deletedNote);

    @Update
    void updateNote(Note changedNote);

    @Query("SELECT * FROM Note") //alle notes zien
    List<Note> findAllNotes();

}
