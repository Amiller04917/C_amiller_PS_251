package edu.wccnet.amiller.addname

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import edu.wccnet.amiller.addname.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var names = arrayOf(String())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun addName(view: View) {
        if (binding.editTextTextPersonName.text.isEmpty())
            return
        names += binding.editTextTextPersonName.text.toString()


        for(name in names){
            if(names[0] == name)
                binding.textView.text = name
            else
                binding.textView.append(name + "\r\n")
        }
    }
}