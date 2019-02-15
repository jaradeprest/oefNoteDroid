package iam.deprest.oefnotedroid.model;

import java.util.ArrayList;

public class NoteDAO {
    private static final NoteDAO ourInstance = new NoteDAO();

    private ArrayList<Note> noteList = new ArrayList<>();

    public static NoteDAO getInstance(){return ourInstance;}

    public ArrayList<Note> getNoteList(){return noteList;}

    public void addNote(Note newNote){noteList.add(newNote);}
}
