package app.bowlinggame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import app.bowlinggame.ui.fragment.activity.LoginActivity
import app.bowlinggame.ui.fragment.activity.SignUpActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        val signUpButton = findViewById<Button>(R.id.signup_button)
        val loginButton = findViewById<Button>(R.id.login_button)
        signUpButton.setOnClickListener(this)
        loginButton.setOnClickListener(this)

        // initialising Firebase auth object
        auth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null) {
            //reload();
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.signup_button -> {
                startActivity(Intent(this, SignUpActivity::class.java))
            }
            R.id.login_button -> {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }
}