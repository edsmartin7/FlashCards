
package com.example.emartin.flashcards;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.widget.ImageView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

/*
Take in an image file and scan it for a TextBlock to parse
 */
public class TextCaptureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_capture_activity);

        //set photo extra to layout
        Intent intent = getIntent();
        Bundle image = intent.getExtras();
        ImageView imageView = (ImageView) findViewById(R.id.photo_image);
        imageView.setImageResource(R.drawable.test1); //

    }

    public void getSomeText() {

        //create text recognizer
        TextRecognizer textRecognizer = new TextRecognizer.Builder().build();
        //get text from input bitmap pic and add to Sparsearray
        Frame frame = new Frame.Builder().setBitmap(pic).build();
        SparseArray<TextBlock> map = textRecognizer.detect(frame);
        //parse sparesearrray and print each line of text to Log

    }

}
