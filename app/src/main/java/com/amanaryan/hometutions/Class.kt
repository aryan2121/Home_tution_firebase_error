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

            i = Intent(this,MainActivity::class.java)

            i.putExtra("class","prep-four")

            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)
            startActivity(i)       }

        five_eight_cardview.setOnClickListener {

            var i = intent

            i = Intent(this,MainActivity::class.java)

            i.putExtra("class","five-eight")

            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)
            startActivity(i)
        }

        nine_ten_cardview.setOnClickListener {

            var i = intent

            i = Intent(this,Subject::class.java)

            i.putExtra("pass","one")
            i.putExtra("subclass","nine-ten")

            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)
            startActivity(i)
        }

        eleven_cardview.setOnClickListener {
            var i = intent

            i = Intent(this,Subject::class.java)

            i.putExtra("pass","nope")

            i.putExtra("subclass","eleven-tweleve")


            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)
            startActivity(i)
        }
    }
}
