package com.example.emartin.flashcards

import android.os.Environment
import android.util.Log
import java.io.*

/**
 * Open Files from computer (txt, pdf, doc) and parse text (separate into two files later)
 */
class FileReader {

    var terms = HashMap<String, String>() //<term, definition>

    //open file (txt, pdf, docx) from computer and read by line
    fun openFile() {

        //read line by line
        try {
            //val filePath: String = "/SD card/Android/media/flashcardtest.txt"
            //val filePath: String = "/home/emartin/Downloads/flashcardtest.txt"
            val filePath: File =  Environment.getExternalStorageDirectory()
            File file  = new File(filePath, "flashcardtest.txt");
            //val bufferedReader = File(filePath).bufferedReader()
            val bufferedReader = filePath.bufferedReader()
            val lineList = mutableListOf<String>()
            bufferedReader.useLines { lines -> lines.forEach { lineList.add(it) } }

            lineList.forEach { parseText(it) }
        } catch (fnfe: FileNotFoundException) {
            Log.e("ERRORS", "fnfe", fnfe)
        }
    }

    //separate by '-'
    fun parseText(line: String) {

        val temp = line.split('-')
        if (temp.size > 1) {
            terms.put(temp[0].trim(), temp[1].trim())
        }
    }

    //get directory to open file from
    fun getDirectory() {

    }

}
