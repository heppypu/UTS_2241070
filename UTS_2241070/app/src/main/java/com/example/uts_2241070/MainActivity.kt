package com.example.uts_2241070

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var edtitle : EditText
    lateinit var btn : Button
    lateinit var radiogrup : RadioGroup
    lateinit var adult : RadioButton
    lateinit var kids : RadioButton
    lateinit var cbt: CheckBox
    lateinit var cbh: CheckBox
    lateinit var cba: CheckBox
    lateinit var cbr: CheckBox
    lateinit var cbc: CheckBox
    lateinit var cbf: CheckBox
    lateinit var spinnerjam : Spinner
    lateinit var spinnertahun : Spinner
    lateinit var spinnermenit : Spinner
    lateinit var radiobuttonChecked : RadioButton
    lateinit var teksTitle : String
    lateinit var teksTonton :String
    lateinit var teksDurasi1 : String
    lateinit var teksTahun : String
    lateinit var teksDurasi:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        edtitle = findViewById(R.id.edTitle)
        btn = findViewById(R.id.btn)
        radiogrup= findViewById(R.id.Grup)
        adult = findViewById(R.id.Adult)
        kids = findViewById(R.id.Kids)
        cbt = findViewById(R.id.cbt)
        cbh = findViewById(R.id.cbh)
        cba = findViewById(R.id.cba)
        cbr = findViewById(R.id.cbr)
        cbc = findViewById(R.id.cbc)
        cbf = findViewById(R.id.cbf)
        spinnertahun = findViewById(R.id.spinnertahun)
        spinnerjam = findViewById(R.id.spinnerjam)
        spinnermenit = findViewById(R.id.spinnermenit)

        btn.setOnClickListener {
            val selectedItem =radiogrup!!.checkedRadioButtonId
            radiobuttonChecked = findViewById(selectedItem)
            teksTonton = radiobuttonChecked.text.toString()
            teksTahun = spinnertahun.selectedItem.toString()
            teksDurasi = spinnerjam.selectedItem.toString()
            teksDurasi1 = spinnermenit.selectedItem.toString()


            val CheckBox = if(cba.isChecked){
                "Thriller"
            }else if(cbh.isChecked){
                "Horor"
            }else if(cbh.isChecked){
                "Horor"
            }else if(cba.isChecked){
                "Action"
            }else if(cbr.isChecked){
                "Romance"
            }else if(cbc.isChecked){
                "Comedy"
            }else if(cbf.isChecked){
                "Fantasy"
            }else{
                "Tidak ada yang di pilih"
        }

                val moveIntent = Intent(this@MainActivity,Next_Page::class.java )
                moveIntent.putExtra(Next_Page.EXTRA_TITLE,edtitle.text.toString())
                moveIntent.putExtra(Next_Page.EXTRA_TONTON,teksTonton)
                moveIntent.putExtra(Next_Page.EXTRA_GENRE,CheckBox)
                moveIntent.putExtra(Next_Page.EXTRA_TAHUN,teksTahun)
                moveIntent.putExtra(Next_Page.EXTRA_DURASI,teksDurasi+"h, "+teksDurasi1+" m")
                startActivity(moveIntent)
        }
    }
}