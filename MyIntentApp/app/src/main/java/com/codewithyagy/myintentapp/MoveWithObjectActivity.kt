package com.codewithyagy.myintentapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MoveWithObjectActivity : AppCompatActivity() {
    companion object {
        // Variabel static bertipe data string yang berfungsi sebagai key
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        // Intent Explicit dengan Parcelable

        val tvObject: TextView = findViewById(R.id.tv_object_received)

        // Mengambil nilai sebuah objek parcelable person
        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person

        // Contoh mengambil kumpulan objek parcelable
        /*
        var persons = intent.getParcelableArrayListExtra<Person>(KEY) as ArrayList<Person>
         */

        // Menampilkan data objek yang sudah diterima
        val text =
            "Name : ${person.name.toString()},\nEmail : ${person.email},\nAge : ${person.age},\nLocation : ${person.city}"
        tvObject.text = text
    }
}