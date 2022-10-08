package app.bowlinggame.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import app.bowlinggame.R

class SignUpFragment : Fragment(), View.OnClickListener {

    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.signup_fragment, container, false)

        username = v.findViewById(R.id.username)
        password = v.findViewById(R.id.password)
        val signUpButton: Button = v.findViewById(R.id.done_button)
        signUpButton.setOnClickListener(this)

        return v
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.done_button -> createAccount()
        }
    }

    private fun createAccount() {
        //TODO: create account code
    }
}