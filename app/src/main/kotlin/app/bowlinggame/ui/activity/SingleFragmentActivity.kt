package app.bowlinggame.ui.fragment

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import app.bowlinggame.R

/**
 * Abstract class for Activity with only one Fragment.
 *
 * TODO: Convert to Kotlin
 *
 * Source: Phillips, Stewart, and Marsicano, Big Nerd Ranch Guide to Android Development, 3rd ed.
 */
abstract class SingleFragmentActivity : AppCompatActivity() {
    protected abstract fun createFragment(): Fragment?

    @get:LayoutRes
    protected val layoutResId: Int
        protected get() = R.layout.activity_fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        val fm = supportFragmentManager
        var fragment = fm.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            fragment = createFragment()
            fm.beginTransaction()
                .add(R.id.fragment_container, fragment!!)
                .commit()
        }
    }
}