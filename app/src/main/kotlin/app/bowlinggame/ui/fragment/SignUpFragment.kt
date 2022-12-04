package app.bowlinggame.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import app.bowlinggame.R
import android.widget.Toast
import app.bowlinggame.model.User
import app.bowlinggame.ui.fragment.activity.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignUpFragment : Fragment(), View.OnClickListener {

    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var etConfPass : EditText

    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth
    // create Firebase database object
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.signup_fragment, container, false)

        username = v.findViewById(R.id.username)
        email = v.findViewById(R.id.email)
        password = v.findViewById(R.id.password)
        etConfPass = v.findViewById(R.id.etSConfPassword)
        val signUpButton: Button = v.findViewById(R.id.done_button)
        signUpButton.setOnClickListener(this)

        // Initialising auth object
        auth = Firebase.auth
        database = Firebase.database.reference

        return v
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.done_button -> createAccount()
        }
    }

    private fun createAccount() {
        val activity = requireActivity()
        val name = username.text.toString()
        val email = email.text.toString()
        val pass = password.text.toString()
        val confirmPassword = etConfPass.text.toString()

        // check pass
        if (name.isBlank() || email.isBlank() || pass.isBlank() || confirmPassword.isBlank()) {
            Toast.makeText(activity.applicationContext, "No fields can be blank", Toast.LENGTH_SHORT).show()
            return
        }

        if (pass != confirmPassword) {
            Toast.makeText(activity, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
                .show()
            return
        }
        if (pass.length < 8 || !pass.contains(Regex("[0-9]")) ) {
            Toast.makeText(activity, "Password must have at least 8 characters and 1 digit", Toast.LENGTH_SHORT)
                .show()
            return
        }


        // If all credential are correct
        // We call createUserWithEmailAndPassword
        // using auth object and pass the
        // email and pass in it.
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(activity) {
            if (it.isSuccessful) {
                Toast.makeText(activity, "Successfully Signed Up", Toast.LENGTH_SHORT).show()
                saveUserData(auth.currentUser!!.uid, name, auth.currentUser!!.email)
                startActivity(Intent(context, HomeActivity::class.java))
            } else {
                Toast.makeText(activity, "Sign Up Failed!", Toast.LENGTH_SHORT).show()
                println(it.exception)
            }
        }
    }

    private fun saveUserData(uid: String, username: String?, email: String?){
        val user = User(uid, email, username, 0, 0)
        database.child("Users").child(uid).setValue(user)
            .addOnCompleteListener{
                Toast.makeText(activity, "User inserted successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{ err ->
                Toast.makeText(activity, "Error: ${err.message}", Toast.LENGTH_SHORT).show()
            }
    }
}