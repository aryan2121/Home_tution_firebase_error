package com.amanaryan.hometutions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var INDOOR: indoor
    lateinit var OUTDOOR: outdoor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        //user


        var std = intent.getStringExtra("class")
        var sub = intent.getStringExtra("subject")
        //std variable me firebase ka class aa rha h

        //profile view start
        constnt_profile.visibility=View.GONE




        textview_profilename.text = intent.getStringExtra("user_name")
        textview_profileEmail.text = intent.getStringExtra("user_email")
        val img = intent.getStringExtra("user_photoUrl")
        Picasso.get().load(img).into(user_image_id)



        //profile view start



        val bottomNavigation : BottomNavigationView = findViewById(R.id.btm_nav)
        signout_profile.setOnClickListener {

            var i = intent

            i = Intent(this,login::class.java)

            i.putExtra("signoutcheck","yes")

            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

            startActivity(i)
        }

        OUTDOOR = outdoor()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fram_layout,OUTDOOR)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        bottomNavigation.setOnNavigationItemSelectedListener { item ->

            when(item.itemId){
                //now add fragment
                R.id.outdoor_nav_id -> {

                    fram_layout.visibility=View.VISIBLE
                    linearlayout.visibility=View.VISIBLE
                    constnt_profile.visibility=View.GONE
                    OUTDOOR = outdoor()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fram_layout,OUTDOOR)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.indoor_nav_id -> {

                    fram_layout.visibility=View.VISIBLE
                    linearlayout.visibility=View.VISIBLE
                    constnt_profile.visibility=View.GONE
                    INDOOR = indoor()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fram_layout,INDOOR)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }


                R.id.profile_nav_id -> {
                    fram_layout.visibility=View.GONE
                    linearlayout.visibility=View.GONE
                    constnt_profile.visibility=View.VISIBLE

                }
            }
            true
        }
    }
}
