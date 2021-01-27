package com.example.homework6

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        read()

    }

    private fun init() {

        sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)


    }

    fun save(view: View) {

        if (emailET.text.toString().isNotEmpty() && firstNameET.text.toString()
                .isNotEmpty() && lastNameET.text.toString().isNotEmpty() &&
            ageET.text.toString().isNotEmpty() && addressET.text.toString().isNotEmpty()
        ) {


            val email = emailET.text.toString()
            val firstName = firstNameET.text.toString()
            val lastName = lastNameET.text.toString()
            val age = ageET.text.toString().toInt()
            val address = addressET.text.toString()

            val editor = sharedPreferences.edit()
            editor.putString("email", email)
            editor.putString("firstName", firstName)
            editor.putString("lastName", lastName)
            editor.putInt("age", age)
            editor.putString("address", address)
            editor.apply()
            Toast.makeText(this, "information saved!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Please, enter missing information!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun read(){
        val email = sharedPreferences.getString("email", "")
        val firstName = sharedPreferences.getString("firstName", "")
        val lastName = sharedPreferences.getString("lastName", "")
        val age = sharedPreferences.getInt("age", 0 )
        val address = sharedPreferences.getString("address", "")

        emailET.setText(email)
        firstNameET.setText(firstName)
        lastNameET.setText(lastName)
        ageET.setText(age.toString())
        addressET.setText(address)
    }
}


