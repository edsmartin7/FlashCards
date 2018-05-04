package com.example.emartin.flashcards;


import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.File;

//Open a dialog box to get an existing file from a file path
//public class FileUploadFragment extends Fragment {
public class FileUploadActivity extends AppCompatActivity {

    private static TextView file_path;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_upload_layout);

        file_path = (TextView) findViewById(R.id.current_dir);
        String path = Environment.getExternalStorageDirectory().toString()+"/Pictures";
        file_path.setText(path);
    }


    public void switchFileSource(View view) {

        //switch (buttonPressed)
        //internal dir
        File directory = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        //sdcard dir
        //File directory = new File(Environment.getExternalStorageDirectory(), "Pictures");
        //File directory = Environment.getExternalStorageDirectory();
        //String path = Environment.getExternalStorageDirectory().toString()+"/Pictures";
        //File directory = new File(path);
        //File directory = this.getExternalFilesDir(null); //Environment.DIRECTORY_PICTURES);
        //File directory = new File(root.getAbsolutePath() + "/Images");
        //other dirs

        File[] files = directory.listFiles();
        Log.d("Files", "Size: "+ files.length);
        for(File file: files)
            Log.d("Files", "FileName:  " + file.getName());

    }
}
