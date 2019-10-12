package com.amanaryan.hometutions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choose.*

class Choose : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
        buttonteacher.setOnClickListener {

            startActivity(Intent(this,logintutor::class.java))
        }
    buttonstudent.setOnClickListener {
        startActivity(Intent(this,login::class.java))


    }
    }


}
