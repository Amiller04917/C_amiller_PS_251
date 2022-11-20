package edu.wccnet.amiller.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.wccnet.amiller.lifecycle.ui.main.MainFragment

class ActivityMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}