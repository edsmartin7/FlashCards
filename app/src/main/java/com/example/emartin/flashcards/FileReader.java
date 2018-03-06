package com.example.emartin.flashcards;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Open Files from computer (txt, pdf, doc) and parse text (separate into two files later)
 */
//rename: name conflict
public class FileReader {

    HashMap<String, String> terms = new HashMap<String, String>(); //<term, definition>

    //open file (txt, pdf, docx) from computer and read by line
    public void openFile(Context context) {
        try {
            //get file path
            //external
            //String filePath = "/SD Card/Android/media/flashcardtest.txt";
            //String dir = Environment.getExternalStorageDirectory().getAbsolutePath();
            File dir2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File dir3 = context.getExternalFilesDir(null);
            //StorageManager sm = (StorageManager)context.getSystemService(Context.STORAGE_SERVICE);
            //sStorageVolume volume = sm.getPrimaryStorageVolume();
            //Intent intent = volume.createAccessIntent(Environment.DIRECTORY_PICTURES);

            //File sdcard = Environment.getExternalStorageDirectory();
            //File file = new File(sdcard, "/Android/media/flashcardtest.txt");
            //internal

            //String filePath = context.getFilesDir() + "/" + "flashcardtest.txt";
            //File file = new File(filePath);
            FileInputStream file = context.openFileInput("flashcardtest.txt");

            //open file from filepath
            //FileInputStream fileInputStream = new FileInputStream(dir);
            //InputStreamReader inputStreamReader = new InputStreamReader();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file));//new java.io.FileReader(file));

            //use buffered reader to read line by line
            String line;
            while ((line=bufferedReader.readLine()) != null) {
                //parsetext(line) and add to hashmap
                Log.i("TAG", "the message is:  " + line);
            }
        } catch (Exception fnfe) {
            Log.e("ERRORS", "file not found", fnfe);
        }
    }

    //separate by '-'
    public void parseText(String line) {
        String[] temp = line.split("-");
        if (temp.length > 1)
            terms.put(temp[0].trim(), temp[1].trim());
    }

    //get directory to open file from
    public void getDirectory() {

    }

}
