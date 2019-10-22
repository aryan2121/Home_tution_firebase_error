package com.amanaryan.hometutions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class profolio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profolio)

        textview_profilename.text = intent.getStringExtra("user_name")
        textview_profileEmail.text = intent.getStringExtra("user_email")
        val img = intent.getStringExtra("user_photoUrl")
        Picasso.get().load(img).into(user_image_id)


        signout_profile.setOnClickListener {

            var i = intent

            i = Intent(this,login::class.java)

            i.putExtra("signoutcheck","yes")

            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

            startActivity(i)
        }
    }
}
