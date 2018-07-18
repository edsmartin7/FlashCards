package com.example.emartin.flashcards.Database;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "questions")
public class Question {

    /*
    @PrimaryKey
    private int uid;
    @ColumnInfo(name = "subject")
    private String subject;
    @ColumnInfo(name = "term")
    private String term;
    @ColumnInfo(name = "definition")
    private String definition;
    */

    @PrimaryKey(autoGenerate = true)
    private int uid;

    public final String subject;
    public final String term;
    public final String definition;
    //exam (sort by a class' exam)
    //date (sort by date added)

    Question(String subject, String term, String definition) {
        this.subject = subject;
        this.term = term;
        this.definition = definition;
    }

    /*
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
    */

    public String getSubject() {
        return subject;
    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }

}
