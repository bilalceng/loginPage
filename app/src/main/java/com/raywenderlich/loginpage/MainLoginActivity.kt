package com.raywenderlich.loginpage

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainLoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private  lateinit var user: String
    private lateinit  var password: String
    private lateinit var userPassword: EditText
    private lateinit var userName: EditText
    private lateinit var recordBtn: Button
    private lateinit var returnBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)
        recordBtn = findViewById(R.id.recordButton)
        returnBtn = findViewById(R.id.returnButton)
        userName = findViewById(R.id.editTtextrecordName)
        userPassword = findViewById(R.id.editTextRecordPassword)



        recordBtn.setOnClickListener {
            user = userName.text.toString()
            password = userPassword.text.toString()

            if (user == ""  || password == "") {

                Toast.makeText(
                    this@MainLoginActivity,
                    "you entered invalid characters!!",
                    Toast.LENGTH_SHORT
                ).show()


            }else{

                sharedPreferences = this.getSharedPreferences("userInfo", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("userName", user).apply()
                editor.putString("password", password).apply()

                Toast.makeText(
                    this@MainLoginActivity,
                    "you are registered successfully",
                    Toast.LENGTH_SHORT
                ).show()

                userName.text.clear()
                userPassword.text.clear()
            }
        }


        returnBtn.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}


