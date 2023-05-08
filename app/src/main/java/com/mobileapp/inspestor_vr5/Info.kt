package com.mobileapp.inspestor_vr5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.cardview.widget.CardView

class Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val linkView: TextView= findViewById(R.id.link)
        linkView.movementMethod= LinkMovementMethod.getInstance()


        val backButton : CardView = findViewById(R.id.back_btn)

        backButton.setOnClickListener{
            finish()
        }

    }
}