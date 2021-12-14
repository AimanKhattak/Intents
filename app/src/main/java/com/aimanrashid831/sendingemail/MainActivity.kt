package com.aimanrashid831.sendingemail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var mEditTextTo : EditText
    private lateinit var mEditTextSubject : EditText
    private lateinit var mEditTextMessage : EditText
    private lateinit var buttonSend : Button
    private lateinit var buttonCamera : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mEditTextTo = findViewById(R.id.edit_text_to)
        mEditTextSubject = findViewById(R.id.edit_text_subject)
        mEditTextMessage = findViewById(R.id.edit_text_message)

        buttonSend = findViewById(R.id.button_send)
        buttonCamera = findViewById(R.id.button_camera)

        buttonCamera.setOnClickListener {
            val intent = Intent(this, CameraIntent::class.java)
            startActivity(intent)
        }


        buttonSend.setOnClickListener{
            sendMail()
        }
    }

    private fun sendMail(){
        val recipientList = mEditTextTo.text.toString()
        val recipients = recipientList.split(",")

        val subject = mEditTextSubject.text.toString()

        val message = mEditTextMessage.text.toString()

        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL, recipients[0])
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, message)

        intent.type = "message/rfc882"

        startActivity(Intent.createChooser(intent,"Choose an email Client"))
    }
}