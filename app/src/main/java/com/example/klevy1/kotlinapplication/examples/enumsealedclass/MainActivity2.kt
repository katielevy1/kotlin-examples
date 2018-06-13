package com.example.klevy1.kotlinapplication.examples.enumsealedclass

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.klevy1.kotlinapplication.R

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setView(ScreenStateEnum2.LOADING)
        otherFunctions()
    }

    private fun setView(screenState : ScreenStateEnum2) {
        val textView = findViewById<TextView>(R.id.main_text)
        textView.text = screenState.getMessage()
    }

    private fun otherFunctions() {
        println(ScreenStateEnum.ERROR.toString()) // Prints ERROR
        println(ScreenStateEnum2.ERROR.name)  // Prints ERROR
        println(ScreenStateEnum2.ERROR.ordinal) // Prints 1
        println(ScreenStateEnum2.valueOf("ERROR")) // String to enum value, prints ERROR
        println(ScreenStateEnum2.valueOf("DOESNTEXIST")) // IllegalArgumentException

    }

}


// an enum but with a parameter of the same type for each enum
// but what if each enum type needs different typed parameters?
private enum class ScreenStateEnum2(val displayString : String) {
    ERROR("Error"),
    LOADING("Loading..."),
    DATA("Displaying data");

    fun getMessage() : String {
        return displayString
    }
}
