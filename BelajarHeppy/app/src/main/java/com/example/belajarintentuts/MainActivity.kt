package com.example.belajarintentuts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var namaPembeli :EditText
    lateinit var btn : Button
    lateinit var grup : RadioGroup
    lateinit var cash : RadioButton
    lateinit var Transfer : RadioButton
    lateinit var spinnerMenu :Spinner
    lateinit var teksLayanan : String
    lateinit var teksMenu : String
    lateinit var radiobuttonChecked : RadioButton
    lateinit var Checkbox : CheckBox
    lateinit var CheckBox1 : CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        namaPembeli = findViewById(R.id.namaPembeli)
        btn=findViewById(R.id.btn)
        grup=findViewById(R.id.grup)
        cash=findViewById(R.id.cash)
        Transfer=findViewById(R.id.Transfer)
        spinnerMenu=findViewById(R.id.spinnerMenu)
        Checkbox = findViewById(R.id.checkbox)
        CheckBox1 = findViewById(R.id.checkbox1)


        btn.setOnClickListener {

            val selectedItem = grup!!.checkedRadioButtonId
            radiobuttonChecked = findViewById(selectedItem)
            teksLayanan = radiobuttonChecked.text.toString()
            teksMenu = spinnerMenu.selectedItem.toString()

            val checkBoxIsi = if(Checkbox.isChecked){
                "Diskon 5%"
            } else{
                "Diskon 10%"
            }

            Toast.makeText(this, checkBoxIsi, Toast.LENGTH_SHORT).show()

            val moveIntent = Intent(this@MainActivity, NextPage ::class.java)
            moveIntent.putExtra(NextPage.EXTRA_NAME,namaPembeli.text.toString())
            moveIntent.putExtra(NextPage.EXTRA_LAYANAN,teksLayanan)
            moveIntent.putExtra(NextPage.EXTRA_MENU,teksMenu)
            moveIntent.putExtra(NextPage.EXTRA_CHECK,checkBoxIsi)
            startActivity(moveIntent)
        }
    }
}