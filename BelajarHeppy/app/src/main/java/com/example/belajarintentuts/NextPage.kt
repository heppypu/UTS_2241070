package com.example.belajarintentuts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NextPage : AppCompatActivity() {
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_LAYANAN = "extra_layanan"
        const val EXTRA_MENU = "extra_menu"
        const val EXTRA_CHECK = "extra_check"
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
        val textReceveidName : TextView = findViewById(R.id.Nama)
        val textReceivedMenu: TextView = findViewById(R.id.menu)
        val textReceivedLayanan: TextView = findViewById(R.id.layanan)
        val textCheck : TextView=findViewById(R.id.promo)

        val name = intent.getStringExtra(EXTRA_NAME)
        val layanan = intent.getStringExtra(EXTRA_LAYANAN)
        val menu = intent.getStringExtra(EXTRA_MENU)
        val checkbox = intent.getStringExtra(EXTRA_CHECK)

        textReceveidName.text = "Nama Pemesan : $name"
        textReceivedLayanan.text = "Pilihan Layanan : $layanan"
        textReceivedMenu.text = "Menu yang dipesan : $menu"
        textCheck.text = "Promo yang dipilih : $checkbox"

        back = findViewById(R.id.back)
        back.setOnClickListener {
            val backIntent = Intent(this@NextPage, MainActivity::class.java)
            startActivity(backIntent)
        }
    }
}