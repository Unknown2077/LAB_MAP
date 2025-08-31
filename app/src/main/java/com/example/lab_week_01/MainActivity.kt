package com.example.lab_week_01

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set the Action Bar title
        supportActionBar?.title = "My First Application"

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        nameSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)
            val studentInput = findViewById<TextInputEditText>(R.id.student_input)

            val name = nameInput.text.toString().trim()
            val student = studentInput.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG).apply {
                    setGravity(Gravity.CENTER, 0, 0)
                    show()
                }
                return@setOnClickListener
            }

            val isStudentValid = student.length == 11 && student.all { it.isDigit() }
            if (!isStudentValid) {
                Toast.makeText(this, getString(R.string.student_invalid), Toast.LENGTH_LONG).apply {
                    setGravity(Gravity.CENTER, 0, 0)
                    show()
                }
                return@setOnClickListener
            }

            nameDisplay.text = getString(R.string.name_greet) + " " + name
        }
    }
}