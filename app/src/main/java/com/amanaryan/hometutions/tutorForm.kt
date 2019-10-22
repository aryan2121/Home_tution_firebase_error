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
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_tutor_form.*
import kotlinx.android.synthetic.main.activity_tutor_form.Greenindoor


class tutorForm : AppCompatActivity() {

    var tutorphotouri: Uri?=null
     var tutorpic:String=""
//spinner

     var taught_class =""
    var specialization_subject=""
    var place_tution=0
    var location=""
    //classes
    var std1=0
    var std8=0
    var std10=0
    var std12=0
    var all=0
    var physics=0
    var chemistery=0
    var biology=0
    var maths=0
    var accounts=0
    var english=0
    var pcmm=0
    var pcbb=0
    //loc
    var lalpur=0
    var raturoad=0
    var doranda=0
    var harmu=0
    var kantatoli=0
    var dhurwa=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutor_form)
       //clasaes
        Greenprep.visibility=View.GONE
        Greenstd5.visibility=View.GONE
        Greenstd9.visibility=View.GONE
        Greenstd11.visibility=View.GONE

        prep.setOnClickListener {
            Greenprep.visibility=View.VISIBLE
            Greenstd5.visibility=View.GONE
            Greenstd9.visibility=View.GONE
            Greenstd11.visibility=View.GONE
            subjectsall.visibility=View.GONE

            all=1
            std1=1}

        std5.setOnClickListener {

            subjectsall.visibility=View.GONE
            Greenprep.visibility=View.GONE
            Greenstd5.visibility=View.VISIBLE
            Greenstd9.visibility=View.GONE
            Greenstd11.visibility=View.GONE
            std8=1
        all=1}

        std9.setOnClickListener {

            subjectsall.visibility=View.VISIBLE
            Greenprep.visibility=View.GONE
            Greenstd5.visibility=View.GONE
            Greenstd9.visibility=View.VISIBLE
            Greenstd11.visibility=View.GONE
            std10=1}

        std11.setOnClickListener {

            subjectsall.visibility=View.VISIBLE
            Greenprep.visibility=View.GONE
            Greenstd5.visibility=View.GONE
            Greenstd9.visibility=View.GONE
            Greenstd11.visibility=View.VISIBLE
            std12=1}
        //classess end



        //subjects
        GreenPhysics.visibility=View.GONE
        Greenchem.visibility=View.GONE
        Greenbio.visibility=View.GONE
        Greenmaths.visibility=View.GONE
        Greeneng.visibility=View.GONE
        GreenAcc.visibility=View.GONE
        Greenpcb.visibility=View.GONE
        Greenpcm.visibility=View.GONE

        bio.setOnClickListener {
            GreenPhysics.visibility=View.GONE
            Greenchem.visibility=View.GONE
            Greenbio.visibility=View.VISIBLE
            Greenmaths.visibility=View.GONE
            Greeneng.visibility=View.GONE
            GreenAcc.visibility=View.GONE
            Greenpcb.visibility=View.GONE
            Greenpcm.visibility=View.GONE

            biology=1}
        chem.setOnClickListener {
            GreenPhysics.visibility=View.GONE
            Greenchem.visibility=View.VISIBLE
            Greenbio.visibility=View.GONE
            Greenmaths.visibility=View.GONE
            Greeneng.visibility=View.GONE
            GreenAcc.visibility=View.GONE
            Greenpcb.visibility=View.GONE
            Greenpcm.visibility=View.GONE

            chemistery=1}

        Physics.setOnClickListener {
            GreenPhysics.visibility=View.VISIBLE
            Greenchem.visibility=View.GONE
            Greenbio.visibility=View.GONE
            Greenmaths.visibility=View.GONE
            Greeneng.visibility=View.GONE
            GreenAcc.visibility=View.GONE
            Greenpcb.visibility=View.GONE
            Greenpcm.visibility=View.GONE

            physics=1}

        mathss.setOnClickListener {
            GreenPhysics.visibility=View.GONE
            Greenchem.visibility=View.GONE
            Greenbio.visibility=View.GONE
            Greenmaths.visibility=View.VISIBLE
            Greeneng.visibility=View.GONE
            GreenAcc.visibility=View.GONE
            Greenpcb.visibility=View.GONE
            Greenpcm.visibility=View.GONE

            maths=1}
        eng.setOnClickListener {
            GreenPhysics.visibility=View.GONE
            Greenchem.visibility=View.GONE
            Greenbio.visibility=View.GONE
            Greenmaths.visibility=View.GONE
            Greeneng.visibility=View.VISIBLE
            GreenAcc.visibility=View.GONE
            Greenpcb.visibility=View.GONE
            Greenpcm.visibility=View.GONE

            english=1}


        Acc.setOnClickListener {
            GreenPhysics.visibility=View.GONE
            Greenchem.visibility=View.GONE
            Greenbio.visibility=View.GONE
            Greenmaths.visibility=View.GONE
            Greeneng.visibility=View.GONE
            GreenAcc.visibility=View.VISIBLE
            Greenpcb.visibility=View.GONE
            Greenpcm.visibility=View.GONE

            accounts=1}

        pcm.setOnClickListener {
            GreenPhysics.visibility=View.GONE
            Greenchem.visibility=View.GONE
            Greenbio.visibility=View.GONE
            Greenmaths.visibility=View.GONE
            Greeneng.visibility=View.GONE
            GreenAcc.visibility=View.GONE
            Greenpcb.visibility=View.GONE
            Greenpcm.visibility=View.VISIBLE

            pcmm=1}

        pcb.setOnClickListener {
            GreenPhysics.visibility=View.GONE
            Greenchem.visibility=View.GONE
            Greenbio.visibility=View.GONE
            Greenmaths.visibility=View.GONE
            Greeneng.visibility=View.GONE
            GreenAcc.visibility=View.GONE
            Greenpcb.visibility=View.VISIBLE
            Greenpcm.visibility=View.GONE

            pcbb=1}
        //subjects End

        //location
        GreenLalpur.visibility=View.GONE
        GreenRatuRoad.visibility=View.GONE
        GreenHarmu.visibility=View.GONE
        GreenKantatoli.visibility=View.GONE
        GreenDhurwa.visibility=View.GONE
        GreenDoranda.visibility=View.GONE

        Lalpur.setOnClickListener {
            GreenLalpur.visibility=View.VISIBLE
            GreenRatuRoad.visibility=View.GONE
            GreenHarmu.visibility=View.GONE
            GreenKantatoli.visibility=View.GONE
            GreenDhurwa.visibility=View.GONE
            GreenDoranda.visibility=View.GONE
            lalpur=1
        }
        RatuRoad.setOnClickListener {
            GreenLalpur.visibility=View.GONE
            GreenRatuRoad.visibility=View.VISIBLE
            GreenHarmu.visibility=View.GONE
            GreenKantatoli.visibility=View.GONE
            GreenDhurwa.visibility=View.GONE
            GreenDoranda.visibility=View.GONE
            raturoad=1
        }

        Harmu.setOnClickListener {
            GreenHarmu.visibility=View.VISIBLE
            GreenRatuRoad.visibility=View.GONE
            GreenLalpur.visibility=View.GONE
            GreenKantatoli.visibility=View.GONE
            GreenDhurwa.visibility=View.GONE
            GreenDoranda.visibility=View.GONE
            harmu=1
        }

        Doranda.setOnClickListener {
            GreenDoranda.visibility=View.VISIBLE
            GreenRatuRoad.visibility=View.GONE
            GreenLalpur.visibility=View.GONE
            GreenKantatoli.visibility=View.GONE
            GreenDhurwa.visibility=View.GONE
            GreenHarmu.visibility=View.GONE
            doranda=1
        }



        Kantatoli.setOnClickListener {
            GreenKantatoli.visibility=View.VISIBLE
            GreenRatuRoad.visibility=View.GONE
            GreenLalpur.visibility=View.GONE
            GreenDoranda.visibility=View.GONE
            GreenDhurwa.visibility=View.GONE
            GreenHarmu.visibility=View.GONE
            kantatoli=1
        }


        Dhurwa.setOnClickListener {
            GreenDhurwa.visibility=View.VISIBLE
            GreenRatuRoad.visibility=View.GONE
            GreenLalpur.visibility=View.GONE
            GreenDoranda.visibility=View.GONE
            GreenKantatoli.visibility=View.GONE
            GreenHarmu.visibility=View.GONE
            kantatoli=1
        }

        //location end
//place
        Greenindoor.visibility=View.GONE
        Greenoutdooor.visibility=View.GONE

        iindoor.setOnClickListener {

            Greenindoor.visibility=View.VISIBLE
            Greenoutdooor.visibility=View.GONE
            place_tution=1
        }
        ooutdoor.setOnClickListener {

            Greenindoor.visibility=View.GONE
            Greenoutdooor.visibility=View.VISIBLE
            place_tution=2
        }
        //place


tutor_img.setOnClickListener {

    val intent=Intent(Intent.ACTION_PICK)
    intent.type="image/*"
    startActivityForResult(intent,0)
}
        tutorformProgressbar.visibility=View.GONE

        Tutor_submitForm.setOnClickListener {
    tutorformProgressbar.visibility=View.VISIBLE
            linearlayout.visibility=View.GONE

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

        val subjects =  Tutor_subjects.text.toString()

        val fee =  Tutor_minimumfee.text.toString()

        val present_address =Tutor_present_address.text.toString()
        var clas=""
        var Spsubject=""
        var loc=""
        val description = Tutor_description.toString()

        val experience = Tutor_experience.toString()

        val ref = FirebaseDatabase.getInstance().getReference("Main/Tutors")
        var place:String="noplace_please review"

        if(place_tution==1){place= "Indoor"}
        if(place_tution==2){place="Outdoor"}
        if (place_tution==0){place="noplace_please_review"}

        if (physics==1){Spsubject="physics"}
        if(chemistery==1){Spsubject="chemistry"}
        if (biology==1){Spsubject="biology"}
        if(maths==1){Spsubject="maths"}
        if (english==1){Spsubject="english"}
        if(accounts==1){Spsubject="accounts"}
        if (pcmm==1){Spsubject="pcm"}
        if(pcbb==1){Spsubject="pcb"}
        if(all==1){Spsubject="all"}




        if(std1==1){ clas="prep to std4"}
        if(std8==1){ clas="std5 to std8"}
        if(std10==1){ clas="std9 to std10"}
        if(std12==1){ clas="std11 to std12"}

        //location start
        if (lalpur==1){ loc="lalpur"}

        if (raturoad==1){ loc="raturoad"}

        if (harmu==1){ loc="harmu"}

        if (doranda==1){ loc="doranda"}

        if (dhurwa==1){ loc="dhurwa"}

        if (kantatoli==1){ loc="kantatoli"}

        //location end

        val value = SaveTutorData(tutor_name,tutorpic,email,loc,qualification,aadhar,mobile,clas,subjects,Spsubject,fee,present_address,place,description, experience)

        ref.child(place).child(clas).child(Spsubject).child(loc).child(tutor_name).setValue(value).addOnSuccessListener {






            Toast.makeText(this, " Data Submited",LENGTH_SHORT).show()
            startActivity(Intent(this,tutor_cnfrm_message::class.java))




        }



            .addOnFailureListener {



                Toast.makeText(this,"data uplload error", LENGTH_SHORT).show()

            }



    }
}
