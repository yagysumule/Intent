package com.codewithyagy.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        // Mengirim Data Pada Intent

        val tvDataReceived: TextView = findViewById(R.id.tv_data_received)

        // Mengambil data
        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0) // Nilai default di sini merupakan nilai yang akan digunakan jika ternyata datanya kosong

        val text = "Name : $name, Your age : $age"
        tvDataReceived.text = text
    }
}