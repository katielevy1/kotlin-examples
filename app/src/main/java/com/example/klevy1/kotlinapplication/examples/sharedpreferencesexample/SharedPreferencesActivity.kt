package com.example.klevy1.kotlinapplication.examples.sharedpreferencesexample

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.klevy1.kotlinapplication.R

class SharedPreferencesActivity : AppCompatActivity() {

    private val prefListener = SharedPreferences.OnSharedPreferenceChangeListener(
            { _ , key ->
                run {
                    when (key) {
                        SharedPreferencesUtil.EXAMPLE_COUNT_ONE -> setCountOneOnScreen()
                        SharedPreferencesUtil.EXAMPLE_COUNT_TWO -> setCountTwoOnScreen()
                        SharedPreferencesUtil.EXAMPLE_BOOLEAN -> setBooleanOnScreen()
                        else -> ""
                    }
                }
            }
    )
    private lateinit var prefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = SharedPreferencesUtil.defaultPrefs(this)
        setContentView(R.layout.shared_pref_layout)

        // Set UI values from Shared Preferences
        setCountOneOnScreen()
        setCountTwoOnScreen()
        setBooleanOnScreen()


        // Set click listeners
        findViewById<Button>(R.id.shared_count_one_increase).setOnClickListener {
            SharedPreferencesUtil.incrementCountOneCount(this)
        }
        findViewById<Button>(R.id.shared_count_two_increase).setOnClickListener {
            SharedPreferencesUtil.incrementCountTwoCount(this)
        }
        findViewById<Button>(R.id.shared_boolean_toggle).setOnClickListener {
            SharedPreferencesUtil.toggleBoolean(this)
        }

        // UI updates on share preferences changing
        prefs.registerOnSharedPreferenceChangeListener(prefListener)


    }

    override fun onDestroy() {
        super.onDestroy()
        prefs.unregisterOnSharedPreferenceChangeListener(prefListener)
    }

    private fun setCountOneOnScreen() {
        findViewById<TextView>(R.id.shared_count_one).text = "Pin: ${SharedPreferencesUtil.getCountOneCount(this)}"
    }

    private fun setCountTwoOnScreen() {
        findViewById<TextView>(R.id.shared_count_two).text = "Fingerprint: ${SharedPreferencesUtil.getCountTwoCount(this)}"

    }
    private fun setBooleanOnScreen() {
        findViewById<TextView>(R.id.shared_boolean).text = "Force Push: ${SharedPreferencesUtil.isBooleanTrue(this)}"

    }
}