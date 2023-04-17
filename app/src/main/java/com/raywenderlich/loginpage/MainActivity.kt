package com.raywenderlich.loginpage

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var passwordId: EditText
    private lateinit var nameId: EditText
    private lateinit var enteredName: String
    private lateinit var enteredPassword: String
    private lateinit var preferences: SharedPreferences
    lateinit var signIn: Button
    lateinit var register: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferences = getSharedPreferences("userInfo", MODE_PRIVATE)

        passwordId = findViewById(R.id.editTextPassword)
        nameId = findViewById(R.id.editTtextusreName)
        signIn = findViewById(R.id.signIn)
        register = findViewById(R.id.register)

        signIn.setOnClickListener {

            enteredName = nameId.text.toString()
            enteredPassword = passwordId.text.toString()

            var recordedName  = preferences.getString("userName","")
            var recordedPassword = preferences.getString("password","")

            if ( recordedName == "" || recordedPassword == ""){
                Toast.makeText(this@MainActivity, "you entered invalid characters!!", Toast.LENGTH_SHORT).show()

            }else if((recordedName == enteredName) && (recordedPassword == enteredPassword)){
                val intent = Intent(applicationContext , MainWelcome::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this@MainActivity, "your password or user name is wrong!!", Toast.LENGTH_SHORT).show()
            }

        }

        register.setOnClickListener {
            val intent = Intent(applicationContext, MainLoginActivity::class.java)
            startActivity(intent)
        }

    }


}