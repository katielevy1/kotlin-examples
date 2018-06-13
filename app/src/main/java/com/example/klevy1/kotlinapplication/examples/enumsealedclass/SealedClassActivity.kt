package com.example.klevy1.kotlinapplication.examples.enumsealedclass

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.klevy1.kotlinapplication.R

class SealedClassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sealedclass_layout)

        findViewById<Button>(R.id.sealed_data).setOnClickListener {
            setView(ScreenStateEnum.DATA)
        }

        findViewById<Button>(R.id.sealed_error).setOnClickListener {
            setView(ScreenStateEnum.ERROR)
        }

        findViewById<Button>(R.id.sealed_loading).setOnClickListener {
            setView(ScreenStateEnum.LOADING)
        }
        otherFunctions()
        EnumPropertyTranslation().runTranslation()
    }

    private fun setView(screenState : ScreenStateEnum) {
        val textView = findViewById<TextView>(R.id.main_text)
         when(screenState) {
            ScreenStateEnum.ERROR -> textView.text = "Error. Unable to display data"
            ScreenStateEnum.LOADING -> textView.text = "Loading..."
            ScreenStateEnum.DATA -> textView.text = "Displaying data here"
        }
    }

    private fun otherFunctions() {
        // Prints ERROR
        println(ScreenStateEnum.ERROR)
        // Prints Name: ERROR and ordinal (index): 0
        println("Name: ${ScreenStateEnum.ERROR.name} and ordinal (index): ${ScreenStateEnum.ERROR.ordinal}")

    }

}

// a very simple enum similar to Java
enum class ScreenStateEnum {
    ERROR,
    LOADING,
    DATA
}
