package com.example.myapplication2

//noinspection SuspiciousImport
import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding object
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Spinner Data
        val countries = arrayOf("Select Country", "USA", "Canada", "Nepal", "UK", "Australia")
        val adapter = ArrayAdapter(this,  android.R.layout.simple_spinner_item, countries)
        binding.spinnerCountry.adapter = adapter

        // Button Click
        binding.btnSubmit.setOnClickListener {
            val fullName = binding.etFullName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val genderId = binding.radioGroupGender.checkedRadioButtonId
            val gender = if (genderId != -1) findViewById<RadioButton>(genderId).text.toString() else "Not specified"
            val country = binding.spinnerCountry.selectedItem.toString()
            val isAgreed = binding.checkBoxAgree.isChecked

            // Validation
            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || country == "Select Country" || !isAgreed) {
                Toast.makeText(this, "Please fill all fields and accept terms", Toast.LENGTH_SHORT).show()
            } else {
                // Pass data to next page
                val intent = Intent(this@MainActivity, DisplayActivity::class.java).apply {
                    putExtra("FULL_NAME", fullName)
                    putExtra("EMAIL", email)
                    putExtra("GENDER", gender)
                    putExtra("COUNTRY", country)
                }
                startActivity(intent)
            }
        }
    }
}
