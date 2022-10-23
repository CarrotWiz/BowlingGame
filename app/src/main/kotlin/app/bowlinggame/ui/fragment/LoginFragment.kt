package app.bowlinggame.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import app.bowlinggame.R
import android.widget.Toast
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
        val v = inflater.inflate(R.layout.login_fragment, container, false)
        loginUsername = v.findViewById(R.id.username)
        loginPassword = v.findViewById(R.id.password)
        val loginButton: Button = v.findViewById(R.id.lg_button)
        loginButton.setOnClickListener(this)

        // initialising Firebase auth object
        auth = FirebaseAuth.getInstance()

        return v
        //return super.onCreateView(inflater, container, savedInstanceState)
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
            } else
                Toast.makeText(activity, "Log In failed ", Toast.LENGTH_SHORT).show()
        }
    }
}