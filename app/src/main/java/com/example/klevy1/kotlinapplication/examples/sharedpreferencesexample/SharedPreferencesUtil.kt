package com.example.klevy1.kotlinapplication.examples.sharedpreferencesexample

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager



object SharedPreferencesUtil {

    const val EXAMPLE_BOOLEAN = "ExampleBoolean"
    const val EXAMPLE_COUNT_ONE = "ExampleCountOne"
    const val EXAMPLE_COUNT_TWO = "ExampleCountTwo"


    fun defaultPrefs(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    private fun customPrefs(context: Context, name: String): SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }

    /**
     * puts a key value pair in shared prefs if doesn't exists, otherwise updates value on given [key]
     */
    operator fun SharedPreferences.set(key: String, value: Any?) {
        when (value) {
            is String? -> edit({ it.putString(key, value) })
            is Int -> edit({ it.putInt(key, value) })
            is Boolean -> edit({ it.putBoolean(key, value) })
            is Float -> edit({ it.putFloat(key, value) })
            is Long -> edit({ it.putLong(key, value) })
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

    /**
     * finds value on given key.
     * [T] is the type of value
     * @param defaultValue optional default value - will take null for strings, false for bool and -1 for numeric values if [defaultValue] is not specified
     */
    inline operator fun <reified T : Any> SharedPreferences.get(key: String, defaultValue: T? = null): T? {
        return when (T::class) {
            String::class -> getString(key, defaultValue as? String) as T?
            Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
            Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
            Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
            Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }


    // Count one
    fun getCountOneCount(context: Context): Int {
        val prefs = defaultPrefs(context)
        return prefs[EXAMPLE_COUNT_ONE] ?: 0
    }

    fun incrementCountOneCount(context: Context) {
        val prefs = defaultPrefs(context)
        var currentCount = getCountOneCount(context)
        currentCount++
        prefs[EXAMPLE_COUNT_ONE] = currentCount
    }


    // Count two
    fun getCountTwoCount(context: Context): Int {
        val prefs = defaultPrefs(context)
        return prefs[EXAMPLE_COUNT_TWO] ?: 0
    }

    fun incrementCountTwoCount(context: Context) {
        val prefs = defaultPrefs(context)
        var currentCount = getCountTwoCount(context)
        currentCount++
        prefs[EXAMPLE_COUNT_TWO] = currentCount
    }


    // boolean
    fun isBooleanTrue(context: Context): Boolean {
        val prefs = defaultPrefs(context)
        return prefs[EXAMPLE_BOOLEAN] ?: true
    }

    fun toggleBoolean(context: Context) {
        val prefs = defaultPrefs(context)
        prefs[EXAMPLE_BOOLEAN] = !isBooleanTrue(context)
    }


}