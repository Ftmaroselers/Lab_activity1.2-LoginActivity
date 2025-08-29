package com.loginactivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val correctUsername = "PAT"
    private val correctPassword = "082004"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsername: EditText = findViewById(R.id.etUsername)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val tvInstruction: TextView = findViewById(R.id.tvInstruction)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (username == correctUsername && password == correctPassword) {
                tvInstruction.text = "Welcome, $username!"
                etUsername.visibility = View.GONE
                etPassword.visibility = View.GONE
                btnLogin.visibility = View.GONE
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                etPassword.text.clear()
                etPassword.requestFocus()
            }
        }
    }
}
