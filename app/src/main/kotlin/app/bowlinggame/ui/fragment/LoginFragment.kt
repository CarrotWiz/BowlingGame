package app.bowlinggame.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import app.bowlinggame.R

class LoginFragment : Fragment(), View.OnClickListener{
    private lateinit var loginUsername: EditText
    private lateinit var loginPassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val v = inflater.inflate(R.layout.login_fragment, container, false)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}