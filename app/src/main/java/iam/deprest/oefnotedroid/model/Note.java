package iam.deprest.oefnotedroid.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Note implements Serializable {

    private String title;
    private String note;
    private String date;
    private Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    public Note() {
    }

    public Note(String title, String note) {
        this.title = title;
        this.note = note;
        this.date = simpleDateFormat.format(calendar.getTime());
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

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
