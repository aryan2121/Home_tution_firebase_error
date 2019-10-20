package com.amanaryan.hometutions

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_tutor_form.*


class tutorForm : AppCompatActivity() {

    var tutorphotouri: Uri?=null
     var tutorpic:String=""
//spinner

     var taught_class =""
    var specialization_subject=""
    var place_tution=""
    var location=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutor_form)
        //Spinners start

         var classs= arrayOf("classes upto you can taught","prep to std 4","std 5 to std 8","std 9 and std 10","std 11 to std 12")
        val classes=findViewById<Spinner>(R.id.classes)
        if(classes!=null){ val arrayAdapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,classs)
        classes.adapter=arrayAdapter

        classes.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
              taught_class=classs.toString()
            }
        }}




        //Tutor_specialization_subject
        var speclsubject= arrayOf("Your specialized Subject","All"," PHY"," Che"," Maths", "Bio"," English"," PCM"," PCB","Accounts")
        val Tutor_specialization_subject=findViewById<Spinner>(R.id.Tutor_specialization_subject)
        if(Tutor_specialization_subject!=null){
            val arrayAdapter1= ArrayAdapter(this,android.R.layout.simple_spinner_item,speclsubject)
            Tutor_specialization_subject.adapter=arrayAdapter1

            Tutor_specialization_subject.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    specialization_subject=speclsubject.toString()
                }
            }}

        //Tutor_place_tution
        var Tutors_place= arrayOf("I can go to students place","Students can come to my place")
        val Tutor_place_tution=findViewById<Spinner>(R.id.Tutor_place_tution)
        if(Tutor_place_tution!=null){
            val arrayAdapter2= ArrayAdapter(this,android.R.layout.simple_spinner_item,Tutors_place)
            Tutor_place_tution.adapter=arrayAdapter2

            Tutor_place_tution.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    place_tution=Tutors_place.toString()
                }
            }}



        //location_tutorform
        var tutorkalocation= arrayOf("Choose Loacations","Piska more","Ratu Road","Lalpur","Main Road","katchury")
        val location_tutorform=findViewById<Spinner>(R.id.location_tutorform)
        if(location_tutorform!=null){
            val arrayAdapter3= ArrayAdapter(this,android.R.layout.simple_spinner_item,tutorkalocation)
            location_tutorform.adapter=arrayAdapter3

            location_tutorform.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    location=tutorkalocation.toString()
                }
            }}

        //spinners End

tutor_img.setOnClickListener {

    val intent=Intent(Intent.ACTION_PICK)
    intent.type="image/*"
    startActivityForResult(intent,0)
}
Tutor_submitForm.setOnClickListener {
    tutorformProgressbar.visibility=View.VISIBLE
    uploadImage()
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


        val tutor_name = Tutor_name.text.toString()



        val email = Tutor_email.text.toString()



        val qualification =  Tutor_qualification.text.toString()



        val aadhar =  Tutor_aadhar_no.text.toString()



        val mobile =  Tutor_mobileno.text.toString()

        //      val taught_class = classes.toString()



        val subjects =  Tutor_subjects.text.toString()


        val fee =  Tutor_minimumfee.text.toString()

        val present_address =Tutor_present_address.text.toString()



        val description = Tutor_description.toString()

        val experience = Tutor_experience.toString()

        val ref = FirebaseDatabase.getInstance().getReference("Main/Tutors")
        var place:String="noplace_please review"

        if(place_tution=="I can go to students place"){place= "Indoor"}
        if(place_tution=="Students can come to my place"){place="Outdoor"}

           val tc=taught_class
        val sc=specialization_subject
        val loc=location

        val value = SaveTutorData(tutor_name,tutorpic,email,location,qualification,aadhar,mobile,taught_class,subjects,specialization_subject,fee,present_address,place,description, experience)

        //,bannerimage1,bannerimage2,bannerimage3,bannerimage4,bannerimage5,instituteimage6

        ref.child(place).child(tc).child(sc).child(loc).child(tutor_name).setValue(value).addOnSuccessListener {

            //getData()





            Toast.makeText(this, " Data Submited",LENGTH_SHORT).show()
            startActivity(Intent(this,tutor_cnfrm_message::class.java))




        }



            .addOnFailureListener {



                Toast.makeText(this,"data uplload error", LENGTH_SHORT).show()

            }



    }
}
