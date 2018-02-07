
package com.example.emartin.flashcards;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

public class TextCapture extends AppCompatActivity {

    private static int RC_HANDLE_CAMERA_PERM = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean autoFocus = true;
        boolean useFlash = false;

        /*
        //check for camera permission
        int rc = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if(rc == PackageManager.PERMISSION_GRANTED)
            createCameraSource(autoFocus, useFlash);
        else
            requestCameraPermission()
            */

    }

    /**
     * Create and start the camera
     */
    /*
    private void createCameraSource(boolean autoFocus, boolean useFlash) {

        Context context = getApplicationContext();
        TextRecognizer textRecognizer = TextRecognizer.Builder(context).build();

        //check if TextRecognizer is operational
        if(!textRecognizer.isOperational()) {
            Log.w("CREATE A TAG", "Detector depedencies are not yet availbe");

            //check for low storage, if low storage then native lib will not be downloaded (detection will
            //not be operational)
            IntentFilter lowStorageFilter = new IntentFilter(Intent.ACTION_DEVICE_STORAGE_LOW);
            boolean hasLowStorage = registerReceiver(null, lowStorageFilter) != null;


            if (hasLowStorage) {
                Toast.makeText(this, R.string.low_storage_error, Toast.LENGTH_LONG).show()
                Log.w("CRETE A TAG", getString(R.string.low_storage_error))
            }

        }

        CameraSource cameraSource = new CameraSource.Builder(getApplicationContext(), textRecognizer)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setRequestedPreviewSize(1280, 1024)
                .setRequestedFps(15.0f)
                .build();
    }
    */

    //.setFlashMode(if(useFlash) Camera.Parameters.FLASH_MODE_TORCH else null)
    //.setFocusMode(if(autoFocus) Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE else null)

    /**
     * Handles requesting camera permissions
     */
    /*
    private void requestCameraPermission() {
        Log.w("TAG", "Camera permission not currently granted.  Requesting Permission...");

        String[] permissions = Manifest.permission.CAMERA.toString();

        if(!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(this, permissions, RC_HANDLE_CAMERA_PERM);
            return;
        }

        Activity activity = this;
        //View listener = new View();
        //listener.setOnClickListener(ActivityCompat.requestPermissions(this, permissions, RC_HANDLE_CAMERA_PERM);

    }
    */

    //remove?
    private void textSplit(TextBlock text) {

    }

    private void getSomeText(Detector.Detections<TextBlock> detections) {
        SparseArray<TextBlock> items = detections.getDetectedItems();
        //can't iterate thru sparsearray
        //for(TextBlock block: detections) {
        //    block.getValue();
        //}
    }

}
