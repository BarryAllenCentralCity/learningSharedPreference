package com.ab.learningsharedpreference

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.SaveButton)
        btn.setOnClickListener { save() }

        val getShared = getSharedPreferences("demo", MODE_PRIVATE)
        val value1 = getShared.getString("str1", "This is default value")
        val txt :TextView = findViewById(R.id.NoteSave)
        txt.text = value1
    }

    private fun save() {
        val msg = findViewById<EditText>(R.id.EditNote).text.toString()

       val shrd: SharedPreferences = this.getSharedPreferences("demo", MODE_PRIVATE)
        val edt: SharedPreferences.Editor = shrd.edit()
        edt.putString("str1", msg)
        edt.apply()


        val txt0: TextView = findViewById(R.id.NoteSave)
        txt0.text = msg
    }

}