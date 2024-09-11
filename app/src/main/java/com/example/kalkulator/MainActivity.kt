package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var number1: EditText
    private lateinit var number2: EditText
    private lateinit var answer: TextView

    override fun onCreate(savedInstanceState: Bundle?) {super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        answer = findViewById(R.id.answer)

        val btnAdd = findViewById<Button>(R.id.btn_add)
        val btnSub = findViewById<Button>(R.id.btn_sub)
        val btnMul = findViewById<Button>(R.id.btn_sul)
        val btnDiv = findViewById<Button>(R.id.btn_div)

        btnAdd.setOnClickListener {
            calculateResult('+')
        }

        btnSub.setOnClickListener {
            calculateResult('-')
        }

        btnMul.setOnClickListener {
            calculateResult('*')
        }

        btnDiv.setOnClickListener {
            calculateResult('/')
        }
    }

    private fun calculateResult(operator: Char) {
        val num1 = number1.text.toString().toDoubleOrNull()
        val num2 = number2.text.toString().toDoubleOrNull()

        if (num1 != null && num2 != null) {
            val result = when (operator) {
                '+' -> num1 + num2
                '-' -> num1 - num2
                '*' -> num1 * num2
                '/' -> if (num2 != 0.0) num1 / num2 else Double.NaN
                else -> Double.NaN
            }

            if (result.isNaN()) {
                answer.text = "Error"
            } else {
                answer.text = result.toString()
            }
        } else {
            answer.text = "Invalid input"}
    }
}