package app.bowlinggame.ui.activity

import androidx.fragment.app.Fragment
import app.bowlinggame.ui.fragment.SignUpFragment
import app.bowlinggame.ui.fragment.SingleFragmentActivity

class SignUpActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment? {
        return SignUpFragment()
    }
}