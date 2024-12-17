package com.example.myapplication2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityDisplayBinding


class DisplayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding object
        binding = ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from Intent
        val fullName = intent.getStringExtra("FULL_NAME") ?: "N/A"
        val email = intent.getStringExtra("EMAIL") ?: "N/A"
        val gender = intent.getStringExtra("GENDER") ?: "Not specified"
        val country = intent.getStringExtra("COUNTRY") ?: "Not specified"


        // Display data
        val details = """
            Full Name: $fullName
            Email: $email
            Gender: $gender
            Country: $country
        """.trimIndent()



        // Update the TextView in the layout with the details
        binding.textViewDetails.text = details
    }
}
