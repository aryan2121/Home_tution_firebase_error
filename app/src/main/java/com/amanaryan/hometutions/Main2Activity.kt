package com.amanaryan.hometutions

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amanaryan.hometutions.profolio
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.view_holder.view.*

class Main2Activity : AppCompatActivity() {
var subject=""
    var classs=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

             val adapter= GroupAdapter<ViewHolder>()
             IndoorRecyclerView.adapter=adapter
        OutdoorRecyclerView.adapter=adapter

        //user


        classs = intent.getStringExtra("class")
        subject = intent.getStringExtra("subject")
        //std variable me firebase ka class aa rha h

        //profile view start


        val user_nm = intent.getStringExtra("user_name")
        val user_email = intent.getStringExtra("user_email")
        val imgg = intent.getStringExtra("user_photoUrl")





        profolioo.setOnClickListener {
            var i = intent

            i = Intent(this,profolio  ::class.java)

            i.putExtra("user_name",user_nm)
            i.putExtra("user_email",user_email)
            i.putExtra("user_photoUrl",imgg)

            startActivity(i)
        }
        //profile view end

        Greenindoor.visibility=View.GONE
        Greenoutdoor.visibility=View.VISIBLE
        outdoorfrme.visibility=View.VISIBLE
        indoorfrme.visibility=View.GONE

        indoor.setOnClickListener {
            Greenindoor.visibility=View.VISIBLE
            Greenoutdoor.visibility=View.GONE
            outdoorfrme.visibility=View.GONE
            indoorfrme.visibility=View.VISIBLE
        }
        outdoor.setOnClickListener {
            Greenindoor.visibility=View.GONE
            Greenoutdoor.visibility=View.VISIBLE
            outdoorfrme.visibility=View.VISIBLE
            indoorfrme.visibility=View.GONE
        }

        indoor_getData()
        outdoor_getData()
    }

    fun indoor_getData() {


        val ref = FirebaseDatabase.getInstance().getReference("Main/Indoor/${classs}/${subject}/raturoad")

        ref.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {

                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

            }



            override fun onDataChange(p0: DataSnapshot) {

                val adapter = GroupAdapter<ViewHolder>()

                p0.children.forEach {

                    val me = it.getValue(SaveTutorData::class.java)

                    Log.d("Save",it.toString())

                    if (me != null)



                        adapter.add(Order(me))

                    Log.d("Save","yhin to hai hi")



                }

                IndoorRecyclerView.adapter = adapter

            }



        })

    }
    fun outdoor_getData() {


        val ref = FirebaseDatabase.getInstance().getReference("Main/Outdoor/${classs}/${subject}/raturoad")

        ref.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {


            }



            override fun onDataChange(p0: DataSnapshot) {

                val adapter = GroupAdapter<ViewHolder>()

                p0.children.forEach {

                    val me = it.getValue(SaveTutorData::class.java)

                    Log.d("Save",it.toString())

                    if (me != null)



                        adapter.add(Order(me))

                    Log.d("Save","yhin to hai hi")



                }

                OutdoorRecyclerView.adapter = adapter

            }



        })

    }

}



class Order(val data : SaveTutorData): Item<ViewHolder>(){

    override fun getLayout(): Int {

        return R.layout.view_holder

    }



    override fun bind(view_Holder: ViewHolder, position: Int) {

        Log.d("Save","yhaan tk pouncha")

        view_Holder.itemView.holder_name.text = data.tutor_name

        view_Holder.itemView.subject.text = data.specialization_subject
        view_Holder.itemView.textView10.text = data.location
        view_Holder.itemView.textView13.text = data.fee//rs

        Picasso.get().load(data.Image).into(view_Holder.itemView.holderimg)

    }



}











//simple recieve
//
//val adapter = GroupAdapter<ViewHolder>()
//
//recyclerView_home.adapter = adapter
//
//
//getData()
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//

//fun getData(){
//
//    val ref = FirebaseDatabase.getInstance().getReference("Marwari/bca")
//
//    ref.addValueEventListener(object : ValueEventListener{
//
//        override fun onCancelled(p0: DatabaseError) {
//
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//
//        }
//
//
//
//        override fun onDataChange(p0: DataSnapshot) {
//
//            val adapter = GroupAdapter<ViewHolder>()
//
//            p0.children.forEach {
//
//                val marwari = it.getValue(SaveData::class.java)
//
//                Log.d("Save",it.toString())
//
//                if (marwari != null)
//
//
//
//                    adapter.add(Order(marwari))
//
//                Log.d("Save","yhin to hai hi")
//
//
//
//            }
//
//            recyclerView_home.adapter = adapter
//
//        }
//
//
//
//    })
//
//}
//
//
//
//
//
//
//}
//
//
//
//
//
//class Order(val data : SaveData): Item<ViewHolder>(){
//
//    override fun getLayout(): Int {
//
//        return R.layout.viewholder
//
//    }
//
//
//
//    override fun bind(viewHolder: ViewHolder, position: Int) {
//
//        Log.d("Save","yhaan tk pouncha")
//
//        viewHolder.itemView.textView_name.text = data.name
//
//
//
//        Picasso.get().load(data.link).into(viewHolder.itemView.imageView2)
//
//    }
//
//
//
//}
