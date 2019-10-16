package com.amanaryan.hometutions


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * A simple [Fragment] subclass.
 */
class outdoor : Fragment() {

    override fun onCreateView
                (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_outdoor, container, false)
   getdata() }

    private  fun getdata() {}
//
//        val array = Array<String>(45){ String()}
//        var number = 1
//        val intent = Intent(context, openInstitute::class.java)
//
//        Toast.makeText(context,"This is Home Activity", Toast.LENGTH_SHORT).show()
//        val ref = FirebaseDatabase.getInstance().getReference("/Institutes/")
//        ref.addValueEventListener(object : ValueEventListener {
//
//            override fun onCancelled(p0: DatabaseError) {
//                Toast.makeText(context,"Sorry Some Error Occurs", Toast.LENGTH_SHORT).show()
//            }
//
//
//            override fun onDataChange(p0: DataSnapshot) {
//
//                val adapter = GroupAdapter<ViewHolder>()
//
//                p0.children.forEach {
//                    //                    array[number] = it.key.toString()
////                    number++
//
//                    val sime = it.childrenCount
//                    Log.d("LELELE",sime.toString())
//
//                    val coaching= it.getValue(uploadInstitute::class.java)
//                    Log.d("HomeFragment", it.toString())
//
//                    adapter.setOnItemClickListener { item, view ->
//                        val coachingItem = item as Order
//                        intent.putExtra(Coaching_Key, coachingItem.coaching)
//                        startActivity(intent)
//
//                    }
//                    if (coaching != null)
//                        adapter.add(Order(coaching,requireContext()))
//
//                    Log.d("Save", "yhin to hai hi")
//                }
//
//                recycleViewHomeId.adapter = adapter
//
//            }
//        })
//    }
}
