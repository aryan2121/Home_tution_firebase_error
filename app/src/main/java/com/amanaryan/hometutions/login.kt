package com.amanaryan.hometutions

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.annotation.IntegerRes
import androidx.core.content.getSystemService

import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.system.exitProcess

class login : AppCompatActivity() {


    private var signIn: SignInButton? = null

    private var signOut: Button? = null

    lateinit var mGoogleSignInClient: GoogleSignInClient

    private var mAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        progress_barId.visibility=View.GONE
        //progress bar

        var profilesignout = intent.getStringExtra("signoutcheck")



        mAuth = FirebaseAuth.getInstance()


        // Configure Google Sign In

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)

            .requestIdToken(getString(R.string.default_web_client_id))

            .requestEmail()

            .build()


        // Build a GoogleSignInClient with the options specified by gso.

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        var m = 0
        if (profilesignout == "yes") {
            mAuth!!.signOut()
            m = 2
            startActivity(Intent(this, splashActivity::class.java))




        }



























        //check user login











        sign_inforStudents_button.setOnClickListener{
            sign_inforStudents_button.visibility=View.GONE
            progress_barId.visibility=View.VISIBLE
            signIn() }




    }


    private fun signIn() {

        val signInIntent = mGoogleSignInClient.signInIntent

        startActivityForResult(signInIntent, RC_SIGN_IN)

    }


    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)





        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);

        if (requestCode == RC_SIGN_IN) {

            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {

                // Google Sign In was successful, authenticate with Firebase

                val account = task.getResult(ApiException::class.java)

                firebaseAuthWithGoogle(account!!)

            } catch (e: ApiException) {

                // Google Sign In failed, update UI appropriately

                Log.w(TAG, "Google sign in failed", e)

                // ...

            }

        }

    }



    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {

        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.id!!)


        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)

        mAuth!!.signInWithCredential(credential)

            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    // Sign in success, update UI with the signed-in user's information

                    Log.d(TAG, "signInWithCredential:success")

                    val user = mAuth!!.currentUser

                    updateUI(user)

                } else {

                    // If sign in fails, display a message to the user.

                    Log.w(TAG, "signInWithCredential:failure", task.exception)

                    Toast.makeText(
                        this@login,
                        "you are not able to log in to google",
                        Toast.LENGTH_LONG
                    ).show()

                    updateUI(null)

                }


                // ...
            }

    }


    private fun updateUI(user: FirebaseUser?) {





        val acct = GoogleSignIn.getLastSignedInAccount(applicationContext)
        var user_name:String=""
        var user_email:String=""
        var user_photoUrl:String=""
        if (acct != null) {

            val personName = acct.displayName.toString()
                user_name=personName
            val personGivenName = acct.givenName.toString()

            val personFamilyName = acct.familyName.toString()

            val personEmail = acct.email.toString()

                user_email=personEmail
            val personId = acct.id.toString()

            val personPhoto = acct.photoUrl.toString()
                user_photoUrl=personPhoto


            Toast.makeText(
                this,
                "Name of the user :$personName",
                LENGTH_SHORT
            ).show()


            val ref = FirebaseDatabase.getInstance().getReference("Main/User/login ")


            val value = SaveData(
                personName,
                personEmail,
                personId,
                personGivenName,
                personFamilyName,
                personPhoto
            )

            ref.child(personName).setValue(value).addOnSuccessListener {
Log.d("lele","please")
                //getData()


                Toast.makeText(this, "saved success", LENGTH_SHORT).show()
                Toast.makeText(this, "SAB HO GYA H  HEHEHE", LENGTH_SHORT).show()
            }


        }

        var i = intent

        i = Intent(this,Choose::class.java)

        i.putExtra("user_name",user_name)
        i.putExtra("user_email",user_email)
        i.putExtra("user_photoUrl",user_photoUrl)

        startActivity(i)
    }

    companion object {

        val RC_SIGN_IN = 1

        val TAG = "MainActivity"
    }


}

//
//override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//
//
//
//    super.onActivityResult(requestCode, resultCode, data)
//
//
//
//    if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {
//
//
//
//        photoUri = data.data
//
//
//
//        Toast.makeText(this," LOGO Selected",LENGTH_SHORT).show()
//
//
//
//    }
//
//
//
//
//
//    if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
//
//
//
//        photoUri1 = data.data
//
//
//
//        Toast.makeText(this," Banner selected",LENGTH_SHORT).show()
//
//
//
//    }
//
//
//
//
//
//    if (requestCode == 2 && resultCode == Activity.RESULT_OK && data != null) {
//
//
//
//        photoUri2 = data.data
//
//
//
//        Toast.makeText(this," 2 ",LENGTH_SHORT).show()
//
//
//
//    }
//
//
//
//
//
//    if (requestCode == 3 && resultCode == Activity.RESULT_OK && data != null) {
//
//
//
//        photoUri3 = data.data
//
//
//
//        Toast.makeText(this," 3",LENGTH_SHORT).show()
//
//
//
//    }
//
//
//
//
//
//    if (requestCode == 4 && resultCode == Activity.RESULT_OK && data != null) {
//
//
//
//        photoUri4 = data.data
//
//
//
//        Toast.makeText(this," 4",LENGTH_SHORT).show()
//
//
//
//    }
//
//
//
//
//
//    if (requestCode == 5 && resultCode == Activity.RESULT_OK && data != null) {
//
//
//
//        photoUri5 = data.data
//
//
//
//        Toast.makeText(this," 5",LENGTH_SHORT).show()
//
//
//
//    }
//
//
//
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
//fun uploadData() {
//
//    var msg: String=""
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
//    computerchckid.setOnCheckedChangeListener { buttonView, isChecked ->
//
//
//
//        if (isChecked){
//
//
//
//            msg= "COMPUTER"
//
//            textView.text=msg
//
//        }
//
//
//
//        if(isChangingConfigurations == false)
//
//
//
//        {
//
//
//
//            msg="NULL"
//
//            textView.text=msg
//
//        }
//
//
//
//    }
//
//    val coachingname = coachingnameid.text.toString()
//
//
//
//    val State = stateid.text.toString()
//
//
//
//    val city =  cityid.text.toString()
//
//
//
//    val type =  typeid.text.toString()
//
//
//
//    val owner =  ownerid.text.toString()
//
//    val addresse = addressid.text.toString()
//
//
//
//    val pincode =  pincodeid.text.toString()
//
//    val price = priceid.text.toString()
//
//    val fasilities =  fasilitiesid.text.toString()
//
//    val mobilenumbre =mobilenumberid.text.toString()
//
//    val location =Locationid.text.toString()
//
//    val msgg = msg
//
//
//
//    val ref = FirebaseDatabase.getInstance().getReference("CoachingDhundhoDatabase")
//
//
//
//
//
//    val value = SaveData(coachingname, State,city,location,type,owner,addresse,pincode,price,fasilities,mobilenumbre,imagelogo,banner1,banner2,banner3,banner4,banner5,msgg)
//
//    //,bannerimage1,bannerimage2,bannerimage3,bannerimage4,bannerimage5,instituteimage6
//
//    ref.child("$State/$city/$location/$type/$coachingname").setValue(value).addOnSuccessListener {
//
//        //getData()
//
//
//
//
//
//        Toast.makeText(this, "saved success",LENGTH_SHORT).show()
//
//        Toast.makeText(this, "SAB HO GYA H  HEHEHE",LENGTH_SHORT).show()
//
//
//
//    }
//
//
//
//        .addOnFailureListener {
//
//
//
//
//
//        }
//
//
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
//fun getData() {
//
//
//
//    val ref = FirebaseDatabase.getInstance().getReference("CoachingDhundhoDatabase")
//
//
//
//    ref.addValueEventListener(object : ValueEventListener {
//
//
//
//        override fun onCancelled(p0: DatabaseError) {
//
//        }
//
//
//
//
//
//        override fun onDataChange(p0: DataSnapshot) {
//
//
//
//            val adapter = GroupAdapter<ViewHolder>()
//
//
//
//            p0.children.forEach {
//
//
//
//                val COACHING = it.getValue(SaveData::class.java)
//
//
//
//
//
//
//
//
//
//                // adapter.add(Order(COACHING)
//
//
//
//
//
//
//
//
//
//            }
//
//
//
//            //recyclerView_home.adapter = adapter
//
//
//
//        }
//
//
//
//
//
//    })
//
//
//
//}
//
//
//
//
//
//fun uploadImage() {
//
//
//
//    var refre = FirebaseStorage.getInstance().getReference("/IMG_LOGO/${coachingnameid.text}")
//
//
//
//    refre.putFile(photoUri!!).addOnSuccessListener {
//
//
//
//        refre.downloadUrl.addOnSuccessListener {
//
//
//
//            imagelogo = it.toString()
//
//
//
//            Toast.makeText(this, "logo added", LENGTH_SHORT).show()
//
//
//
//        }
//
//
//
//    }
//
//
//
//        .addOnFailureListener {
//
//
//
//            Toast.makeText(this, "upload error",LENGTH_SHORT).show()
//
//
//
//        }
//
//
//
//
//
//
//
//    var refre1 = FirebaseStorage.getInstance().getReference("/Banner_IMG1/${coachingnameid.text}")
//
//
//
//    refre1.putFile(photoUri1!!).addOnSuccessListener {
//
//
//
//        refre1.downloadUrl.addOnSuccessListener {
//
//
//
//            banner1 = it.toString()
//
//
//
//            Toast.makeText(this, "Banner1 added", LENGTH_SHORT).show()
//
//
//
//        }
//
//
//
//    }
//
//
//
//        .addOnFailureListener {
//
//
//
//            Toast.makeText(this, "banner 1 upload error",LENGTH_SHORT).show()
//
//
//
//        }
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
//
//    var refre2 = FirebaseStorage.getInstance().getReference("/Banner_IMG2/${coachingnameid.text}")
//
//
//
//    refre2.putFile(photoUri2!!).addOnSuccessListener {
//
//
//
//        refre2.downloadUrl.addOnSuccessListener {
//
//
//
//            banner2 = it.toString()
//
//
//
//            Toast.makeText(this, "Banner2 added", LENGTH_SHORT).show()
//
//
//
//        }
//
//
//
//    }
//
//
//
//        .addOnFailureListener {
//
//
//
//            Toast.makeText(this, "banner 2 upload error",LENGTH_SHORT).show()
//
//
//
//        }
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
//    var refre3 = FirebaseStorage.getInstance().getReference("/Banner_IMG3/${coachingnameid.text}")
//
//
//
//    refre3.putFile(photoUri3!!).addOnSuccessListener {
//
//
//
//        refre3.downloadUrl.addOnSuccessListener {
//
//
//
//            banner3 = it.toString()
//
//
//
//            Toast.makeText(this, "Banner3 added", LENGTH_SHORT).show()
//
//
//
//        }
//
//
//
//    }
//
//
//
//        .addOnFailureListener {
//
//
//
//            Toast.makeText(this, "banner 3 upload error",LENGTH_SHORT).show()
//
//
//
//        }
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
//    var refre4 = FirebaseStorage.getInstance().getReference("/Banner_IMG4/${coachingnameid.text}")
//
//
//
//    refre4.putFile(photoUri4!!).addOnSuccessListener {
//
//
//
//        refre4.downloadUrl.addOnSuccessListener {
//
//
//
//            banner4 = it.toString()
//
//
//
//            Toast.makeText(this, "Banner4 added", LENGTH_SHORT).show()
//
//
//
//        }
//
//
//
//    }
//
//
//
//        .addOnFailureListener {
//
//
//
//            Toast.makeText(this, "banner 4 upload error",LENGTH_SHORT).show()
//
//
//
//        }
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
//
//
//
//    var refre5 = FirebaseStorage.getInstance().getReference("/cochng_IMG5/${coachingnameid.text}")
//
//
//
//    refre5.putFile(photoUri5!!).addOnSuccessListener {
//
//
//
//        refre5.downloadUrl.addOnSuccessListener {
//
//
//
//            banner5 = it.toString()
//
//
//
//            Toast.makeText(this, "Banner5 added", LENGTH_SHORT).show()
//
//
//
//            uploadData()
//
//
//
//
//
//
//
//        }
//
//
//
//    }
//
//
//
//        .addOnFailureListener {
//
//
//
//            Toast.makeText(this, "banner 5 upload error",LENGTH_SHORT).show()
//
//
//
//        }
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
//}
//
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
//class Order(val data: SaveData) : Item<ViewHolder>() {
//
//
//
//    override fun getLayout(): Int {
//
//
//
//        return R.layout.viewholder
//
//
//
//    }
//
//
//
//
//
//    override fun bind(viewHolder: ViewHolder, position: Int) {
//
//
//
//
//
//        viewHolder.itemView.textView_name.text = data.coachingname
//
//        viewHolder.itemView.textView_fee.text = data.price
//
//        viewHolder.itemView.textView_add.text = data.addresse
//
//
//
//        viewHolder.itemView.fasilities_id.text = data.fasilities
//
//        viewHolder.itemView.mobilenumber_id.text = data.mobilenumber
//
//
//
//        Picasso.get().load(data.link).into(viewHolder.itemView.imageView2)
//
//
//
//    }
//
//
//
//
//
//}


