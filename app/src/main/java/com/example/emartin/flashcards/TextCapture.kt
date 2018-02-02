package com.example.emartin.flashcards

import android.Manifest
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.hardware.Camera
import android.nfc.Tag
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.res.TypedArrayUtils.getString
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.util.SparseArray
import android.view.View
import android.widget.Toast

import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.text.TextBlock
import com.google.android.gms.vision.text.TextRecognizer


class TextCapture: AppCompatActivity() {

    private val RC_HANDLE_CAMERA_PERM: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var autoFocus = true
        var useFlash = false

        //check for camera permission
        var rc: Int = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        if (rc == PackageManager.PERMISSION_GRANTED) {
            createCameraSource(autoFocus, useFlash)
        } else {
            requestCameraPermission()
        }

    }

    /**
     * Create and start the camera
     */
    private fun createCameraSource(autoFocus: Boolean, useFlash: Boolean) {
        val context: Context = getApplicationContext()
        val textRecognizer: TextRecognizer = TextRecognizer.Builder(context).build()

        //Check if TextRecognizer is operational
        if (!textRecognizer.isOperational()) {
            Log.w(TAG, "Detector dependencies are not yet available")
            //check for low storage, if low storage then native lib will not be downloaded (detection will
            //not be operational)
            val lowstorageFilter= IntentFilter(Intent.ACTION_DEVICE_STORAGE_LOW)
            val hasLowStorage: Boolean = registerReceiver(null, lowstorageFilter) != null

            if (hasLowStorage) {
                Toast.makeText(this, R.string.low_storage_error, Toast.LENGTH_LONG).show()
                Log.w(TAG, getString(R.string.low_storage_error))
            }
        }

        //create camera source using textRecognizer
        val cameraSource =
                CameraSource.Builder(getApplicationContext(), textRecognizer)
                        .setFacing(CameraSource.CAMERA_FACING_BACK)
                        .setRequestedPreviewSize(1280, 1024)
                        .setRequestedFps(15.0f)
                        .build()
    }
    //.setFlashMode(if(useFlash) Camera.Parameters.FLASH_MODE_TORCH else null)
    //.setFocusMode(if(autoFocus) Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE else null)

    /**
     * Handles requesting camera permissions
     */
    private fun requestCameraPermission() {
        Log.w(TAG, "Camera permission not currently granted.  Requesting Permission...")

        //val permissions = Array(Manifest.permission.CAMERA.toString())
        val permissions = arrayOf(Manifest.permission.CAMERA.toString())

        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(this, permissions, RC_HANDLE_CAMERA_PERM)
            return
        }

        val thisActivity: Activity = this

        //val listener: View
        //listener.setOnClickListener {
        //    ActivityCompat.requestPermissions(thisActivity, permissions, RC_HANDLE_CAMERA_PERM)
        //}

    }

    private fun textSplit(text: TextBlock) {

    }
    //same as above?
    private fun getSomeText(detections: Detector.Detections<TextBlock>) {

        val items: SparseArray<TextBlock> = detections.detectedItems
        //can't iterate thru sparse array
        //for (item in items) {
        //    item.getValue() // do something with textblock
        //}
    }

}
