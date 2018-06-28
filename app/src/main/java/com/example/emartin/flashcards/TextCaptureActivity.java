
package com.example.emartin.flashcards;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextDetector;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Take in an image file and scan it for a TextBlock to parse
 */
public class TextCaptureActivity extends AppCompatActivity {

    private Bitmap photoImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_capture_activity);

        LinearLayout imageLayout = (LinearLayout) findViewById(R.id.pic_image);
        ImageView imageView = new ImageView(TextCaptureActivity.this);
        photoImage = getBitmapFromAsset(this, "test2.jpg");
        imageView.setImageBitmap(photoImage); // needs to be size adjusted
        imageLayout.addView(imageView);
    }

    //ml-kit codelab method to detect text in images
    //Text recognizer
    public void getSomeText(View view) {

        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(photoImage);
        FirebaseVisionTextDetector detector = FirebaseVision.getInstance().getVisionTextDetector();

        detector.detectInImage(image)
                .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
                    @Override
                    public void onSuccess(FirebaseVisionText firebaseVisionText) {
                        processTextRecognitionResults(firebaseVisionText);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                    }
                });

    }

    //ml-kit codelab method to parse text blocks from image
    public void processTextRecognitionResults(FirebaseVisionText texts) {

        List<FirebaseVisionText.Block> blocks = texts.getBlocks();

        if (blocks.size() == 0) {
            Toast.makeText(getApplicationContext(), "No Text Found", Toast.LENGTH_SHORT).show();
            return;
        }

        //blocks
        //lines
        //elements (words) // N/A, parsing by line
        for(int x=0; x<blocks.size(); x++) {
            List<FirebaseVisionText.Line> lines = blocks.get(x).getLines();
            for(int y=0; y<lines.size(); y++) {
                FirebaseVisionText.Line currentLine = lines.get(y);
                System.out.println(currentLine.getText());
            }
        }

    }

    //ml-kit codelab method to get .jpg from asset folder
    public static Bitmap getBitmapFromAsset(Context context, String filePath) {
        AssetManager assetManager = context.getAssets();

        InputStream is;
        Bitmap bitmap = null;
        try {
            is = assetManager.open(filePath);
            bitmap = BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

}
