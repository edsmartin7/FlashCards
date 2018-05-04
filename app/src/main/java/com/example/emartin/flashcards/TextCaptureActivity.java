
package com.example.emartin.flashcards;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

/*
Take in an image file and scan it for a TextBlock to parse
 */
public class TextCaptureActivity extends AppCompatActivity {

    private static String TAG = "application errors xoxo";

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

        Context context = getApplicationContext();

        //create text recognizer
        TextRecognizer textRecognizer = new TextRecognizer.Builder(context).build();

        //Check if the TextRecognizer is operational
        if (!textRecognizer.isOperational()) {
            Log.w(TAG, "Detector dependencies are not yet available.");

            // Check for low storage.  If there is low storage, the native library will not be
            // downloaded, so detection will not become operational.
            IntentFilter lowstorageFilter = new IntentFilter(Intent.ACTION_DEVICE_STORAGE_LOW);
            boolean hasLowStorage = registerReceiver(null, lowstorageFilter) != null;

            if (hasLowStorage) {
                Toast.makeText(this, R.string.low_storage_error, Toast.LENGTH_LONG).show();
                Log.w(TAG, getString(R.string.low_storage_error));
            }


            //get text from input bitmap pic and add to Sparsearray
            //Frame frame = new Frame.Builder().setBitmap(pic).build();
            //SparseArray<TextBlock> map = textRecognizer.detect(frame);
            //parse sparesearrray and print each line of text to Log

            //release TextRecognizer in onDestroy()
        }

    }

}
