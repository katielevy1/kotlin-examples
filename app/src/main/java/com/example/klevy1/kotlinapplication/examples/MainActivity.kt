package com.example.klevy1.kotlinapplication.examples

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.klevy1.kotlinapplication.R
import com.example.klevy1.kotlinapplication.examples.enumsealedclass.SealedClassActivity
import com.example.klevy1.kotlinapplication.examples.sharedpreferencesexample.SharedPreferencesActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.sealed_class).setOnClickListener {
            goToSealedClass()
        }

        findViewById<TextView>(R.id.shared_preferences).setOnClickListener {
            goToSharedPreferences()
        }

    }

    private fun goToSharedPreferences() {
        val intent = Intent(this, SharedPreferencesActivity::class.java)
        startActivity(intent)
    }

    private fun goToSealedClass() {
        val intent = Intent(this, SealedClassActivity::class.java)
        startActivity(intent)
    }

}

