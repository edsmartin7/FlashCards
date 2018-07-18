package com.example.emartin.flashcards.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuestionDao {

    @Query("SELECT * FROM questions")
    List<Question> getAllQuestions();

    @Query("SELECT * FROM questions WHERE subject=:subject")
    List<Question> getSubjectQuestions(String subject);

    @Insert
    void insertAll(Question... questions);

    //@Delete
    //void delete(Question question);
    @Delete
    void delete(Question... question);

}
