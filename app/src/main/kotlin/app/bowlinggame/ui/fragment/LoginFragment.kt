package app.bowlinggame.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Surface
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import app.bowlinggame.R
import android.widget.Toast
import app.bowlinggame.ui.fragment.activity.HomeActivity
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment(), View.OnClickListener{
    private lateinit var loginUsername: EditText
    private lateinit var loginPassword: EditText

    // Creating firebaseAuth object
    lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View
        val activity = requireActivity()
        val rotation = activity.windowManager.defaultDisplay.rotation
        v = if(rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            inflater.inflate(R.layout.login_fragment_land, container, false)
        } else {
            inflater.inflate(R.layout.login_fragment, container, false)
        }

        loginUsername = v.findViewById(R.id.username)
        loginPassword = v.findViewById(R.id.password)
        val loginButton: Button = v.findViewById(R.id.lg_button)
        loginButton.setOnClickListener(this)

        // initialising Firebase auth object
        auth = FirebaseAuth.getInstance()

        return v
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.lg_button -> authAccount()
        }
    }

    private fun authAccount() {
        val uname = loginUsername.text.toString()
        val pass = loginPassword.text.toString()
        // calling signInWithEmailAndPassword(email, pass)
        // function using Firebase auth object
        // On successful response Display a Toast
        auth.signInWithEmailAndPassword(uname, pass).addOnCompleteListener(requireActivity()) {
            if (it.isSuccessful) {
                Toast.makeText(activity, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                startActivity(Intent(context, HomeActivity::class.java))
            } else
                Toast.makeText(activity, "Log In failed ", Toast.LENGTH_SHORT).show()
        }
    }
}