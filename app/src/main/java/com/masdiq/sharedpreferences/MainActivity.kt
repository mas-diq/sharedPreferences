package com.masdiq.sharedpreferences

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val PREFS_NAME = "BelajarSharedPrefrence"
    val KEY_EMAIL = "key.email"
    val KEY_PASSWORD = "key.password"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_logout.setOnClickListener() {
            logOut()
        }
    }

    private fun logOut() {
        clearData()
        getEmail()
        getPassword()
    }

    private fun clearData() {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    private fun getEmail(): String? = sharedPreferences.getString(KEY_EMAIL, null)
    private fun getPassword(): String? = sharedPreferences.getString(KEY_PASSWORD, null)
}