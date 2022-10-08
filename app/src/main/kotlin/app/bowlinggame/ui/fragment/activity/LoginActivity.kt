package app.bowlinggame.ui.fragment.activity

import androidx.fragment.app.Fragment
import app.bowlinggame.ui.fragment.LoginFragment
import app.bowlinggame.ui.fragment.SignUpFragment
import app.bowlinggame.ui.fragment.SingleFragmentActivity

class LoginActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment? {
        return LoginFragment()
    }
}