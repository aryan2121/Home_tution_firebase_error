package com.amanaryan.hometutions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_logintutor.*

class logintutor : AppCompatActivity() {


    private var signIn: SignInButton? = null

    private var signOut: Button? = null

    lateinit var mGoogleSignInClient: GoogleSignInClient

    private var mAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logintutor)



//
//        signIn = findViewById<View>(R.id.sign_inforStudents_button) as SignInButton
//        signIn = findViewById<View>(R.id.sign_in_forTechars_button) as SignInButton




            mAuth = FirebaseAuth.getInstance()


            // Configure Google Sign In

            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)

                .requestIdToken(getString(R.string.default_web_client_id))

                .requestEmail()

                .build()


            // Build a GoogleSignInClient with the options specified by gso.

            mGoogleSignInClient = GoogleSignIn.getClient(this, gso)


            sign_infortutors_button.setOnClickListener { signIn() }




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
                            this@logintutor,
                            "you are not able to log in to google",
                            Toast.LENGTH_LONG
                        ).show()

                        updateUI(null)

                    }


                    // ...
                }

        }


        private fun updateUI(user: FirebaseUser?) {


            // signOut.setVisibility(View.VISIBLE);


            val acct = GoogleSignIn.getLastSignedInAccount(applicationContext)

            if (acct != null) {

                val personName = acct.displayName.toString()

                val personGivenName = acct.givenName.toString()

                val personFamilyName = acct.familyName.toString()

                val personEmail = acct.email.toString()

                val personId = acct.id.toString()

                val personPhoto = acct.photoUrl.toString()



                Toast.makeText(
                    this,
                    "Name of the user :$personName",
                    Toast.LENGTH_SHORT
                ).show()





                val ref = FirebaseDatabase.getInstance().getReference("User/Tutors")





                val value = SaveData(personName,personEmail,personId,personGivenName,personFamilyName,personPhoto)

                ref.child("personName/personEmail").setValue(value).addOnSuccessListener {

                    //getData()


                    Toast.makeText(this, "saved success", Toast.LENGTH_SHORT).show()
                    Toast.makeText(this, "SAB HO GYA H  HEHEHE", Toast.LENGTH_SHORT).show()
                }





            }

            startActivity(Intent(this,tutorForm::class.java))
        }

        companion object {

            val RC_SIGN_IN = 1

            val TAG = "MainActivity"
        }


    }