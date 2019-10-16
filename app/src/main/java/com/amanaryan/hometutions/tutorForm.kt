package com.amanaryan.hometutions

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_tutor_form.*


class tutorForm : AppCompatActivity() {

    var tutorphotouri: Uri?=null
     var tutorpic:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutor_form)

tutor_img.setOnClickListener {

    val intent=Intent(Intent.ACTION_PICK)
    intent.type="image/*"
    startActivityForResult(intent,0)
}
Tutor_submitForm.setOnClickListener { uploadImage() }

xxxxxxxxxx.setOnClickListener {
    tutorpic="xxxxxx"
    uploadData()
}
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    if(requestCode==0&&resultCode==Activity.RESULT_OK&& data!=null)
    {tutorphotouri=data.data
    Toast.makeText(this,"photo Selected", LENGTH_SHORT).show()}
    }



    fun uploadImage(){

        val referi=FirebaseStorage.getInstance().getReference("/Tutors_IMG/${Tutor_name.text}")
        referi.putFile(tutorphotouri!!)
            .addOnSuccessListener {

            referi.downloadUrl.addOnSuccessListener {
                tutorpic=it.toString()

                uploadData()
            }
                Toast.makeText(this,"photo Uploaded", LENGTH_SHORT).show()
        }

            .addOnFailureListener{
                Toast.makeText(this,"photo uplload error", LENGTH_SHORT).show()

            }
    }

    fun uploadData() {


val location=location_tutorform.toString()
        val tutor_name = Tutor_name.text.toString()



        val email = Tutor_email.text.toString()



        val qualification =  Tutor_qualification.text.toString()



        val aadhar =  Tutor_aadhar_no.text.toString()



        val mobile =  Tutor_mobileno.text.toString()

        val taught_class = classes.toString()



        val subjects =  Tutor_subjects.text.toString()

        val specialization_subject = Tutor_specialization_subject.toString()
        val fee =  Tutor_minimumfee.text.toString()

        val present_address =Tutor_present_address.text.toString()

        val place_tution=Tutor_place_tution.toString()

        val description = Tutor_description.toString()

        val experience = Tutor_experience.toString()

        val ref = FirebaseDatabase.getInstance().getReference("Main/Tutors")
        var place:String="noplace_please review"

if(place_tution=="I can go to students place"){place= "Indoor"}
        if(place_tution=="Students can come to my place"){place="Outdoor"}



        val value = SaveTutorData(tutor_name,tutorpic,email,qualification,aadhar,mobile,taught_class,subjects,specialization_subject,fee,present_address,place_tution,description, experience)

        //,bannerimage1,bannerimage2,bannerimage3,bannerimage4,bannerimage5,instituteimage6

        ref.child(tutor_name).setValue(value).addOnSuccessListener {

            //getData()





            Toast.makeText(this, " Data Submited",LENGTH_SHORT).show()





        }



            .addOnFailureListener {



                Toast.makeText(this,"data uplload error", LENGTH_SHORT).show()

            }



    }
}
