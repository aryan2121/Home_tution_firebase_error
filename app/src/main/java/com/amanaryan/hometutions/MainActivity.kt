package com.amanaryan.hometutions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var INDOOR: indoor
    lateinit var OUTDOOR: outdoor
    lateinit var PROFILE: profile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigation : BottomNavigationView = findViewById(R.id.btm_nav)

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
                    OUTDOOR = outdoor()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fram_layout,OUTDOOR)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.indoor_nav_id -> {
                    INDOOR = indoor()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fram_layout,INDOOR)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }


                R.id.profile_nav_id -> {
                    PROFILE = profile()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fram_layout,PROFILE)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
            }
            true
        }
    }
}
