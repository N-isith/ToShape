package com.example.toshape

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var rvBMIs: RecyclerView
    private lateinit var adapter: BMIAdapter
    private val bmis: List<BMIs> = listOf(
        // Sample data for demonstration purposes
        BMIs("45KG", "154cm"),
        BMIs("67KG", "172cm"),
        BMIs("62KG", "166cm"),
        BMIs("77KG", "178cm"),
        BMIs("71KG", "182cm"),

        // ... add more books here
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rvBMIs = findViewById(R.id.rv_bmis)
        adapter = BMIAdapter(this, bmis)
        rvBMIs.layoutManager = LinearLayoutManager(this)
        rvBMIs.adapter = adapter
        val fabAddBMI: FloatingActionButton = findViewById(R.id.btn_add_BMI)
        fabAddBMI.setOnClickListener {
            // Intent to go to AddBMIActivity or show a dialog to add a BMI
            val intent = Intent(this, AddBMIActivity2::class.java)
            startActivity(intent)
        }

    }
}
