package com.example.bmicalculation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BMIActivity : AppCompatActivity() {
    var bmiIndex: Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        val tfWelcome = findViewById<TextView>(R.id.tfWelcome)
        val personName = intent?.getStringExtra("personName")
        tfWelcome.setText(personName)

        if (savedInstanceState != null){
            bmiIndex = savedInstanceState.getDouble("bmi")

            val tfStatus = findViewById<TextView>(R.id.tfStatus)
            tfStatus.setText(getStatus())
        }

        val btnCal = findViewById<Button>(R.id.btnCalculate)
        btnCal.setOnClickListener(){
            val weight = findViewById<TextView>(R.id.tfWeight).text.toString()
            val height = findViewById<TextView>(R.id.tfHeight).text.toString()

            bmiIndex = weight.toDouble() / (height.toDouble() * height.toDouble())

            val tfStatus = findViewById<TextView>(R.id.tfStatus)
            tfStatus.setText(getStatus())
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.getDouble("bmi", bmiIndex)
    }

    private fun getStatus():String{

        if(bmiIndex < 18.5)
            return "Underweight"
        else if(bmiIndex <= 24.9)
            return "Normal Weight"
        else if(bmiIndex <= 24.9)
            return "Overweight"
        else if(bmiIndex <= 24.9)
            return "Obesity Class I"
        else if(bmiIndex <= 24.9)
            return "Obesity Class II"
        else
            return "Obesity Class III"
    }
}