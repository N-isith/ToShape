package com.example.toshape

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BMIsActivity : AppCompatActivity() {

    private lateinit var tvweight: TextView
    private lateinit var tvHeight: TextView
    private lateinit var btnEdit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bmis)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvweight = findViewById(R.id.tv_weight)
        tvHeight = findViewById(R.id.tv_height)
        btnEdit = findViewById(R.id.btn_edit)
        // Get the bmi's position or ID passed from MainActivity
        val bmiId = intent.getIntExtra("BMI_ID", -1)
        if (bmiId != -1) {
            // Fetch the bmi details based on the bookId.
            // For demonstration purposes, I'm using a sample list.
            // In a real application, you might fetch this from a database or other data source.
            val bmi = fetchBmiDetails(bmiId)
            // Update the UI with the book details
            tvweight.text = bmi.weight
            tvHeight.text = bmi.height
            btnEdit.setOnClickListener {
                val intent = Intent(this, AddBMIActivity2::class.java)
                intent.putExtra("BMI_ID", bmiId)
                startActivity(intent)
            }
        } else {
            // Handle error case where no valid bmiId is provided
            Toast.makeText(this, "Error fetching BMI details.", Toast.LENGTH_SHORT).show()
        }
    }
    private fun fetchBmiDetails(bmiId: Int): BMIs {
        // This is a sample function. In a real app, fetch the bmi details based on the bmiId.
        // For demonstration, I'm returning a sample bmi.
        return BMIs("Sample Weight", "Sample Height")
    }
}