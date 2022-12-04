package app.bowlinggame.ui.fragment.activity

import androidx.fragment.app.Fragment
import app.bowlinggame.ui.fragment.HistoryFragment
import app.bowlinggame.ui.fragment.SingleFragmentActivity

class HistoryActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment? {
        return HistoryFragment()
    }
}