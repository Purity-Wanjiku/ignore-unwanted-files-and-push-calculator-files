package com.computation.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.computation.calculator.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding  //eliminates crushes that happen when casting views

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dividebtn.setOnClickListener { calculations('%') }
        binding.subtractbtn.setOnClickListener { calculations('-') }
        binding.addbtn.setOnClickListener { calculations('+') }
        binding.multiplybtn.setOnClickListener { calculations('*') }
    }


//  4

    fun calculations(operator: Char) {
        binding.tilinput1.error = null
        binding.tilinput2.error = null
        val num1 = binding.etinput1.text.toString()
        val num2 = binding.etinput2.text.toString()
        var error = false

        if (num1.isBlank()) {
            binding.tilinput1.error = getString(R.string.input1_error)
            error = true
        }
        if (num2.isBlank()) {
            binding.tilinput2.error = getString(R.string.input2_error)
            error = true
        }

        if (!error) {
            val firstNum = num1.toDouble()
            val secondNum = num2.toDouble()
            val result = when (operator) {
                '+' -> firstNum + secondNum
                '-' -> firstNum - secondNum
                '*' -> firstNum * secondNum
                '%' -> firstNum % secondNum
                else -> throw IllegalArgumentException("Invalid operator:$operator")
            }
            binding.tvanswer.text = result.toString()
        }
    }
}