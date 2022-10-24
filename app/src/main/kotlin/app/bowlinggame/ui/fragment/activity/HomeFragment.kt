package app.bowlinggame.ui.fragment.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import app.bowlinggame.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment(), View.OnClickListener{
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.home_fragment, container, false)
        auth = Firebase.auth
        val singlePlayerButton: Button = v.findViewById(R.id.single_player_button)


        return v
    }

    override fun onClick(view: View) {
        when(view.id) {

        }
    }
}