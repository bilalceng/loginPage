package com.raywenderlich.loginpage

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainWelcome : AppCompatActivity() {
    private lateinit var preferences: SharedPreferences
    private lateinit var passwordArea: TextView
    private lateinit var nameArea: TextView
    lateinit var logOut: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_welcome)

        preferences = getSharedPreferences("userInfo", MODE_PRIVATE)
        logOut = findViewById(R.id.logOut)
        passwordArea = findViewById(R.id.textuserInfo)
        nameArea = findViewById(R.id.textPasswordInfo)

        var password = preferences.getString("password","")
        var userName = preferences.getString("userName", "")

        passwordArea.text = "Your Name: " + userName.toString()
        nameArea.text = "your Password: " + password.toString()
        logOut.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}