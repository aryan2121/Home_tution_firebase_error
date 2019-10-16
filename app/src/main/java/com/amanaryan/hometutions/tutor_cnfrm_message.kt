package com.amanaryan.hometutions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tutor_cnfrm_message.*

class tutor_cnfrm_message : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutor_cnfrm_message)
        message.setOnClickListener {
            startActivity(Intent(this,Choose::class.java))
        }
    }
}
