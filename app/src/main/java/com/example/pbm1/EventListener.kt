package com.example.pbm1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabLayout.ViewPagerOnTabSelectedListener

class EventListener : AppCompatActivity(), View.OnClickListener {
    //deklarasi variable I/O (komponen seperti text view, Edittext, Button. dsb)

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_event_listener)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //hubungkan komponen xml layout dengan variabel di kotlin
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)

        //Memasang Event Listener pada button
        // Cara ke-1 : diDalam method onCreate
        btn1.setOnClickListener {
            //Logic Program disini >> menjalankan apa
            //Memunculkan notifikasi (mirip dengan J Optione Pane)
            Toast.makeText(this, "Tombol 1 sudah diklik", Toast.LENGTH_LONG).show()
        }
// 2. Menggunakan Implements class View.onClickListener
        // didalam onCreate harus deklarasi set onClick Listener
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
        //safe operator >> aksesnya menggunakan if/when
        when (v?.id) { //isi variabel v adalah id. onClick >> id >> button
            R.id.btn3 -> { // ketika button 3 diklik maka.. menjalankan apa
                Toast.makeText(this, "Tombol 3 sudah diklik", Toast.LENGTH_LONG).show()
            }

            R.id.btn4 -> { // ketika button 3 diklik maka.. menjalankan apa
                Toast.makeText(this, "Tombol 4 sudah diklik", Toast.LENGTH_LONG).show()
            }
        }
    }
}