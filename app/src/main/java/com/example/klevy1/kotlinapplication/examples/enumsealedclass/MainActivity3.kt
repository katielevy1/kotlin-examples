package com.example.klevy1.kotlinapplication.examples.enumsealedclass

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.klevy1.kotlinapplication.R

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setView(ScreenStateEnum3.Data(DataObject("This is the main message",
                500)))
    }

    private fun setView(screenState : ScreenStateEnum3) {
        val textView = findViewById<TextView>(R.id.main_text)
        // when statement doesn't need an else/default statement
        // if we forget a subclass, we'll get an error at compile time
        when (screenState) {
            // smart casts to Error, Loading, or Data
            is ScreenStateEnum3.Error -> { textView.text = screenState.errorMessage }
            // we do not need "is" as it is a singleton
            ScreenStateEnum3.Loading -> { textView.visibility = View.GONE }
            is ScreenStateEnum3.Data -> { textView.text = screenState.dataToDisplay.message }
        }
    }


}


// a sealed class (you can think of an extension of an enum class)
// where each item has different typed parameters
// Big differences are:
// 1. Sealed classes can be inherited from
// 2. Their subclasses can have multiple instances
// 3. Their subclasses can contain different state
sealed class ScreenStateEnum3 {
    data class Error(val errorMessage : String) : ScreenStateEnum3()
    // if a subclass doesn't have state, then we can use object to make it a singleton
    object Loading : ScreenStateEnum3()
    data class Data(val dataToDisplay : DataObject) : ScreenStateEnum3()
}

data class DataObject(val message : String, val timeToReceiveMs : Int)


