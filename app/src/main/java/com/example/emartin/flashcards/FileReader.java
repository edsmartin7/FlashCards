package com.example.emartin.flashcards;

import android.util.Log;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Open Files from computer (txt, pdf, doc) and parse text (separate into two files later)
 */
//rename: name conflict
public class FileReader {

    HashMap<String, String> terms = new HashMap<String, String>(); //<term, definition>

    //open file (txt, pdf, docx) from computer and read by line
    public void openFile() {
        try {
            //get file path
            //open file from filepath
            //use buffered reader to read line by line
            //parsetext(line) and add to hashmap
        } catch (FileNotFoundException fnfe) {
            Log.e("ERRORS", "file not found", fnfe);
        }
    }

    //separate by '-'
    public void parseText(String line) {
        String[] temp = line.split("-");
        if(temp.length > 1)
            terms.put(temp[0].trim(), temp[1].trim());
    }

    //get directory to open file from
    public void getDirectory() {

    }

}
