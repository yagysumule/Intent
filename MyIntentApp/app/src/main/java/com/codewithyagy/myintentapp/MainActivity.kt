package com.codewithyagy.myintentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Intent Explicit
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        // Mengirim Data Pada Intent
        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        // Intent Explicit dengan Parcelable
        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        // Intent Implicit
        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        // Intent dengan ResultActivity
        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            // Intent Explicit
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            // Mengirim Data Pada Intent
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }

            // Intent Explicit dengan Parcelable
            R.id.btn_move_activity_object -> {

                // Menciptakan sebuah objek Person bernama person (kelas Person merupakan Parcelable)
                val person = Person(
                    "DicodingAcademy",
                    5,
                    "academy@dicoding.com",
                    "Bandung"
                )

                // Mengirimkan objek ke kelas MoveWithObjectActivity
                val moveWithObjectIntent =
                    Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)

                // Contoh mengirimkan kumpulan objek parcelable ke activity lain
                /*
                var persons = ArrayList<Person>()
                ...
                moveWithObjectIntent.putParcelableArrayListExtra(KEY, persons)
                 */
            }

            // Intent Implicit
            R.id.btn_dial_number -> {
                val phoneNumber = "08121081234"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            // Intent dengan ResultActivity
            R.id.btn_move_for_result -> {

                /* Pada baris ini kita akan menjalankan sebuah activity melalui intent untuk nilai balik
                   ke activity yang menjalankan di mana nilai REQUEST_CODE adalah 110.
                   Penentuan nilai 110 itu dibebaskan dan kalau bisa disesuaikan dengan kebutuhan pengemabangan aplikasi
                 */
                val moveForResultIntent =
                    Intent(this@MainActivity, MoveForResultActivity::class.java)
                startActivityForResult(moveForResultIntent, REQUEST_CODE)
            }
        }
    }

    // Ketika MoveForResultActivity telah tertutup sempurna, maka metode onActivityResult() pada MainActivity akan dijalankan
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Pada baris 113 di bawah, dilakukan perbandingan apakah requestCode sama dengan yang dikirimkan oleh MainActivity.
        if (requestCode == REQUEST_CODE) {
            /* Pada baris 117 di bawah, periksa apakah nilai resultCode sama yang dikirim oleh MoveForResultActivity.
               Bila iya, maka data radiobutton yang dipilih akan ditampilkan di textview tvResult.
             */
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil : $selectedValue"
            }
        }
    }
}