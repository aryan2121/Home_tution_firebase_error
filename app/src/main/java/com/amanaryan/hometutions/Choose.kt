package com.amanaryan.hometutions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choose.*

class Choose : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
        var user_name = intent.getStringExtra("user_name")
        var user_email = intent.getStringExtra("user_email")
        var user_photoUrl = intent.getStringExtra("user_photoUrl")
        buttonteacher.setOnClickListener {
            var i = intent

            i = Intent(this,tutorForm::class.java)

            startActivity(i)
        }

    buttonstudent.setOnClickListener {
        var i = intent

        i = Intent(this,studentForm::class.java)

        i.putExtra("user_name",user_name)
        i.putExtra("user_email",user_email)
        i.putExtra("user_photoUrl",user_photoUrl)

        startActivity(i)


    }
    }


}
