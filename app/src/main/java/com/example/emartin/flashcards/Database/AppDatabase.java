package com.example.emartin.flashcards.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Question.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract QuestionDao questionDao();

    /*
    code to get db in a file
    AppDatabase db = Room.databaseBuilder(getApplicationContext(),
        AppDatabase.class, "database-name").build();
     */

    //add create method???
}
