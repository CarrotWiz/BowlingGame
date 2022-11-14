package app.bowlinggame.ui.fragment.activity

import androidx.fragment.app.Fragment
import app.bowlinggame.ui.fragment.SingleFragmentActivity

class HomeActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment? {
        return HomeFragment()
    }
}