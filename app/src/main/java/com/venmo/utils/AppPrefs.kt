package com.venmo.utils

import android.content.Context
import android.content.SharedPreferences
import java.util.*

class AppPrefs(context: Context) {

    private var sharedPreferences: SharedPreferences? = null

    init {
        sharedPreferences = context.getSharedPreferences(
            PREFS_FILE,
            Context.MODE_PRIVATE)
    }


    private val preferences: SharedPreferences?
        get() {
            if (sharedPreferences != null) {
                return sharedPreferences
            }
            throw RuntimeException(
                "AppPrefs not correctly instantiated."
            )
        }

    val all: Map<String, *>
        get() = preferences!!.all

    fun getInt(key: String?, defValue: Int): Int {
        return preferences!!.getInt(key, defValue)
    }

    fun getBoolean(key: String?, defValue: Boolean): Boolean {
        return preferences!!.getBoolean(key, defValue)
    }

    fun getLong(key: String?, defValue: Long): Long {
        return preferences!!.getLong(key, defValue)
    }

    fun getDouble(key: String?, defValue: Double): Double {
        return java.lang.Double.longBitsToDouble(
            preferences!!.getLong(
                key,
                java.lang.Double.doubleToLongBits(defValue)
            )
        )
    }

    fun getFloat(key: String?, defValue: Float): Float {
        return preferences!!.getFloat(key, defValue)
    }

    fun getString(key: String?, defValue: String?): String? {
        return preferences!!.getString(key, defValue)
    }

    fun getStringSet(
        key: String?,
        defValue: Set<String?>?
    ): Set<String>? {
        val prefs = preferences
        return prefs!!.getStringSet(key, defValue)
    }

    fun getOrderedStringSet(
        key: String,
        defValue: Set<String?>
    ): Set<String?> {
        val prefs = preferences
        if (prefs!!.contains(key + LENGTH)) {
            val set =
                LinkedHashSet<String?>()
            val stringSetLength = prefs.getInt(key + LENGTH, -1)
            if (stringSetLength >= 0) {
                for (i in 0 until stringSetLength) {
                    set.add(prefs.getString("$key[$i]", null))
                }
            }
            return set
        }
        return defValue
    }

    fun putLong(key: String?, value: Long) {
        val editor = preferences!!.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    fun putInt(key: String?, value: Int) {
        val editor = preferences!!.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun putDouble(key: String?, value: Double) {
        val editor = preferences!!.edit()
        editor.putLong(key, java.lang.Double.doubleToRawLongBits(value))
        editor.apply()
    }

    fun putFloat(key: String?, value: Float) {
        val editor = preferences!!.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    fun putBoolean(key: String?, value: Boolean) {
        val editor = preferences!!.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun putString(key: String?, value: String?) {
        val editor = preferences!!.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun putStringSet(
        key: String?,
        value: Set<String?>?
    ) {
        val editor = preferences!!.edit()
        editor.putStringSet(key, value)
        editor.apply()
    }

    fun remove(key: String) {
        val prefs = preferences
        val editor = prefs!!.edit()
        if (prefs.contains(key + LENGTH)) { // Workaround for pre-HC's lack of StringSets
            val stringSetLength = prefs.getInt(key + LENGTH, -1)
            if (stringSetLength >= 0) {
                editor.remove(key + LENGTH)
                for (i in 0 until stringSetLength) {
                    editor.remove("$key[$i]")
                }
            }
        }
        editor.remove(key)
        editor.apply()
    }

    operator fun contains(key: String?): Boolean {
        return preferences!!.contains(key)
    }

    fun clear(): SharedPreferences.Editor {
        val editor = preferences!!.edit().clear()
        editor.apply()
        return editor
    }

    fun edit(): SharedPreferences.Editor {
        return preferences!!.edit()
    }


    companion object {
        private const val LENGTH = "#LENGTH"
        private const val PREFS_FILE = "romio.prefs"
    }
}