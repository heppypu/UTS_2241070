package com.example.uts_2241070

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Next_Page : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_TONTON = "extra_tonton"
        const val EXTRA_GENRE = "extra_genre"
        const val EXTRA_TAHUN = "extra_tahun"
        const val EXTRA_DURASI = "extra_durasi"
       lateinit var back : Button
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_next_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textReceivedTitle : TextView = findViewById(R.id.Title)
        val textReceivedtTonton : TextView = findViewById(R.id.Tonton)
        val textGenre : TextView = findViewById(R.id.Genre)
        val textTahun : TextView = findViewById(R.id.Tahun)
        val textReceivedDurasi : TextView = findViewById(R.id.Durasi)

        val Title = intent.getStringExtra(EXTRA_TITLE)
        val Tonton = intent.getStringExtra(EXTRA_TONTON)
        val Genre = intent.getStringExtra(EXTRA_GENRE)
        val Tahun = intent.getStringExtra(EXTRA_TAHUN)
        val Durasi = intent.getStringExtra(EXTRA_DURASI)


        textReceivedTitle.text = "Judul Film: $Title"
        textReceivedtTonton.text = "Watch For : $Tonton"
        textGenre.text = "Genre : $Genre"
        textTahun.text = "Tahun : $Tahun"
        textReceivedDurasi.text = " Durasi Film : $Durasi"

        back = findViewById(R.id.back)
        back.setOnClickListener {
            val backIntent = Intent(this@Next_Page, MainActivity::class.java)
            startActivity(backIntent)
        }
    }
}