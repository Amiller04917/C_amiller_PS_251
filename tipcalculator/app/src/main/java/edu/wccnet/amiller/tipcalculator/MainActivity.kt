package edu.wccnet.amiller.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import edu.wccnet.amiller.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun calculateTip(view: View) {
        if(binding.billTotal.text.isEmpty()){
            binding.textField.text = "YOU MUST ENTER A BILL AMOUNT"
            return
        }

        val input = binding.billTotal.text.toString().toFloat()
        val ten = "%.2f".format(input + (input * 0.1f))
        val fifteen = "%.2f".format(input + (input * 0.15f))
        val twenty = "%.2f".format(input + (input * 0.20f))

        // This is done just so the linter will stop complaining about concatenation.
        val text = "The tips are as follows:\r\n" +
                "10% = ${ten}\r\n"+
                "15% = ${fifteen}\r\n"+
                "20% = ${twenty}\r\n"

        binding.textField.text = text
    }
}