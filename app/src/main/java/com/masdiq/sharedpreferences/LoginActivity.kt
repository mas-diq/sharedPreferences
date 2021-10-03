package com.masdiq.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    val PREFS_NAME = "BelajarSharedPrefrence"
    val KEY_EMAIL = "key.email"
    val KEY_PASSWORD = "key.password"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        btn_login.setOnClickListener { onLogin() }
    }

    private fun onLogin() {
        val email: String = input_email.text.toString()
        saveEmail(email)
        val passwod: String = input_password.text.toString()
        savePassword(passwod)
        message()
    }

    private fun saveEmail(email: String) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(KEY_EMAIL, email)
        editor.apply()
    }

    private fun savePassword(passwod: String) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(KEY_PASSWORD, passwod)
        editor.apply()
    }

    private fun message() {
        val email: String = input_email.text.toString()
        val password: String = input_password.text.toString()
        when {
            email == "" -> {
                val msg: Toast =
                    Toast.makeText(applicationContext, "Masukan email", Toast.LENGTH_LONG)
                msg.setGravity(Gravity.TOP, 0, 260)
                msg.show()
            }
            password == "" -> {
                val msg: Toast =
                    Toast.makeText(applicationContext, "Masukan password", Toast.LENGTH_LONG)
                msg.setGravity(Gravity.TOP, 0, 260)
                msg.show()
            }
            else -> {
                val msg: Toast =
                    Toast.makeText(applicationContext, "Berhasil Login", Toast.LENGTH_SHORT)
                msg.setGravity(Gravity.TOP, 0, 240)
                msg.show()
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}