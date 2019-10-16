package com.amanaryan.hometutions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_class.*
import kotlinx.android.synthetic.main.activity_subject.*

class Subject : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject)


        var user_name = intent.getStringExtra("user_name")
        var user_email = intent.getStringExtra("user_email")
        var user_photoUrl = intent.getStringExtra("user_photoUrl")

        //user



        var pass = intent.getStringExtra("pass")


        if(pass=="one"){
            TEN_all.visibility = View.VISIBLE
            English.visibility=View.VISIBLE
            Eleven_Tweleve_PCM.visibility = View.GONE
            Accounts.visibility = View.GONE
        }
        else
        {
            TEN_all.visibility = View.GONE

            English.visibility=View.GONE
            Eleven_Tweleve_PCM.visibility = View.VISIBLE
            Accounts.visibility = View.VISIBLE

        }

        TEN_all.setOnClickListener {

            var i = intent

            i = Intent(this,MainActivity::class.java)

            i.putExtra("subject","all")
            i.putExtra("class","nine-ten")

            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)

            startActivity(i)
        }
        Eleven_Tweleve_PCM.setOnClickListener {

            var i = intent

            i = Intent(this,MainActivity::class.java)

            i.putExtra("subject","pcm")
            i.putExtra("class","elleven-tweleve")

            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)

            startActivity(i)
        }


        Phy.setOnClickListener {
            var subclass = intent.getStringExtra("subclass")

            var i = intent

            i = Intent(this,MainActivity::class.java)

            i.putExtra("subject","physics")
            i.putExtra("class",subclass.toString())

            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)

            startActivity(i)
        }
        chemistry.setOnClickListener {
            var subclass = intent.getStringExtra("subclass")

            var i = intent

            i = Intent(this,MainActivity::class.java)

            i.putExtra("subject","chemistry")
            i.putExtra("class",subclass.toString())

            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)

            startActivity(i)
        }
        maths.setOnClickListener {
            var subclass = intent.getStringExtra("subclass")

            var i = intent

            i = Intent(this,MainActivity::class.java)

            i.putExtra("subject","maths")
            i.putExtra("class",subclass.toString())

            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)

            startActivity(i)
        }


        bio.setOnClickListener {
            var subclass = intent.getStringExtra("subclass")

            var i = intent

            i = Intent(this,MainActivity::class.java)

            i.putExtra("subject","biology")
            i.putExtra("class",subclass.toString())

            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)

            startActivity(i)
        }



        Accounts.setOnClickListener {
            var subclass = intent.getStringExtra("subclass")

            var i = intent

            i = Intent(this,MainActivity::class.java)

            i.putExtra("subject","accounts")
            i.putExtra("class","eleven-tweleve")

            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)

            startActivity(i)
        }
        English.setOnClickListener {
            var subclass = intent.getStringExtra("subclass")

            var i = intent

            i = Intent(this,MainActivity::class.java)

            i.putExtra("subject","english")
            i.putExtra("class","nine-ten")

            i.putExtra("user_name",user_name)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",user_photoUrl)

            startActivity(i)
        }


    }
}


//
//var i = intent
//
//i = Intent(this@MainActivity,Main2Activity::class.java)
//
//i.putExtra("abc","123".toString())
//
//startActivity(i)
//
//
//
//
//var name = intent.getStringExtra("abc")
//
//tv.text = "Hello...!!! $name"