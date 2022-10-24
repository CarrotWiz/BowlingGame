package app.bowlinggame.ui.fragment.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import app.bowlinggame.MainActivity
import app.bowlinggame.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.home_fragment, container, false)
        val singlePlayerButton: Button = v.findViewById(R.id.single_player_button)
        val historyButton: Button = v.findViewById(R.id.history_button)
        val logoutButton: Button = v.findViewById(R.id.logout_button)
        singlePlayerButton.setOnClickListener(this)
        historyButton.setOnClickListener(this)
        logoutButton.setOnClickListener(this)
        auth = Firebase.auth

        return v
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.single_player_button -> singlePlayerButtonClick()
            R.id.history_button -> historyButtonClick()
            R.id.logout_button -> logoutButtonClick()
        }
    }

    private fun singlePlayerButtonClick() {

    }

    private fun historyButtonClick() {

    }

    private fun logoutButtonClick() {
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}