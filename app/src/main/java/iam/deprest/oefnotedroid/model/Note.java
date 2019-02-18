package iam.deprest.oefnotedroid.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Note implements Serializable {

    static int counter;

    private String title;
    private String note;
    private String date;
    private Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
    private int id;

    public Note() {
        counter++;
        id = counter;
    }

    public Note(String title, String note) {
        counter++;
        this.title = title;
        this.note = note;
        this.date = simpleDateFormat.format(calendar.getTime());
        this.id = counter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", date='" + date + '\'' +
                ", calendar=" + calendar +
                ", simpleDateFormat=" + simpleDateFormat +
                ", id=" + id +
                '}';
    }
}
