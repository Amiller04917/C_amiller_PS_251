package edu.wccnet.amiller.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.wccnet.amiller.recycleview.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val intn = getIntent()

        binding.textView.setText(intn.getStringExtra("imageTitle"))

        binding.textView2.setText(intn.getStringExtra("ImageDetail"))

//        val draw = intn.getIntExtra("Image", -1)
//        binding.imageView.setImageResource(draw)
    }
}