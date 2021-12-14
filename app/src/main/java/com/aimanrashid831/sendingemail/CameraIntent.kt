package com.aimanrashid831.sendingemail

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CameraIntent : AppCompatActivity() {
    private lateinit var buttonCamera : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_camera_intent)
        buttonCamera = findViewById(R.id.button_camera)
        buttonCamera.setOnClickListener {
            launchCam()
        }


    }
    private fun launchCam(){
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
            val cameraIntent = null
            startActivity(cameraIntent)
        }
    }
}