package com.example.toshape

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddBMIActivity2 : AppCompatActivity() {

    private lateinit var edtWeight: EditText
    private lateinit var edtHeight: EditText
    private lateinit var btnSave: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_bmiactivity2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edtWeight = findViewById(R.id.edt_weight)
        edtHeight = findViewById(R.id.edt_height)
        btnSave = findViewById(R.id.btn_save)
        btnSave.setOnClickListener {
            val weight = edtWeight.text.toString()
            val height = edtHeight.text.toString()
            if (weight.isNotEmpty() && height.isNotEmpty()) {
                // Create a new book instance
                val newBMI = BMIs(weight, height)
                // Notify user, e.g., using a Toast
                Toast.makeText(this, "BMI added successfully!", Toast.LENGTH_SHORT).show()
                // Return to the previous activity (e.g., MainActivity)
                finish()
            } else {
                // Notify user to fill out required fields
                Toast.makeText(this, "Please fill out required fields!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}