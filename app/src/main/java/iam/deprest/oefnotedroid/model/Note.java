package iam.deprest.oefnotedroid.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Note implements Serializable {

    @PrimaryKey (autoGenerate = true)
    private long id;
    private String title;
    private String note;
    private Date publishDate;


    public Note() {
    }

    @Ignore
    public Note(String title, String note, Date publishDate) {
        this.title = title;
        this.note = note;
        this.publishDate = publishDate;
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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }
}
