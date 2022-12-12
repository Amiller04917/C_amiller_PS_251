package edu.wccnet.amiller.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.wccnet.amiller.contacts.databinding.ActivityMainBinding;
import edu.wccnet.amiller.contacts.databinding.FragmentMainBinding
import edu.wccnet.amiller.contacts.ui.main.MainFragment
import edu.wccnet.amiller.contacts.ui.main.RecyclerAdapter
import kotlinx.coroutines.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
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