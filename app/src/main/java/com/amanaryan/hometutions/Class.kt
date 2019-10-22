package com.amanaryan.hometutions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_class.*

class Class : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)


        var user_name = intent.getStringExtra("user_name")
        var user_email = intent.getStringExtra("user_email")
        var user_photoUrl = intent.getStringExtra("user_photoUrl")

        //user


        prep_four_cardview.setOnClickListener {
            var i = intent

            i = Intent(this,Main2Activity::class.java)

            i.putExtra("class","prep to std4")
            i.putExtra("subject","all")

            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)
            startActivity(i)       }

        five_eight_cardview.setOnClickListener {

            var i = intent

            i = Intent(this,Main2Activity::class.java)

            i.putExtra("class","std5 to std8")

            i.putExtra("subject","all")
            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)
            startActivity(i)
        }

        nine_ten_cardview.setOnClickListener {

            var i = intent

            i = Intent(this,Subject::class.java)

            i.putExtra("pass","one")
            i.putExtra("subclass","std9 to std10")

            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)
            startActivity(i)
        }

        eleven_cardview.setOnClickListener {
            var i = intent

            i = Intent(this,Subject::class.java)

            i.putExtra("pass","nope")

            i.putExtra("subclass","std11 to std12")


            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)
            startActivity(i)
        }
    }
}
