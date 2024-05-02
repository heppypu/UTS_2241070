package com.example.pbm1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.newFixedThreadPoolContext

class BMI_Activity : AppCompatActivity() {
    //obj = String, Array, dst
    lateinit var edBerat :EditText
    lateinit var edTinggi :EditText
    lateinit var btn :Button
    lateinit var spinner: Spinner
    val item = listOf("Pilih Massa Tubuh","Dewasa", "Anak - Anak")
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bmi)

        spinner = findViewById(R.id.spinner2)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, item)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter= arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItems = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        edBerat = findViewById(R.id.numberWeight)
        edTinggi = findViewById(R.id.numberHeight)
        btn = findViewById(R.id.btnCalculate)



        //set event Listener
        btn.setOnClickListener {
            val isiBerat = edBerat.text.toString()
            val isiTinggi = edTinggi.text.toString()
            val result : TextView = findViewById(R.id.result)

            when{
                isiBerat.isNullOrBlank()->{
                    Toast.makeText(this,"Harus diisi",Toast.LENGTH_LONG)
                }
                isiTinggi.isNullOrBlank()->{
                    Toast.makeText(this,"Harus diisi",Toast.LENGTH_LONG)
                }
                else ->{
                    //convert ke float/double
                    val hitungBMI = isiBerat.toFloat()/((isiTinggi.toFloat()/100)*(isiTinggi.toFloat()/100))
                    result.text = hitungBMI.toString()
                }
            }

        }
    }
    private fun resultBMI(bmi : Float){
        val result : TextView = findViewById(R.id.result)
        result.text = bmi.toString()

        when{
            bmi <18.5 ->{
                Toast.makeText(this,"Underweight", Toast.LENGTH_LONG).show()
            }
                bmi in 18.5 .. 24.9 -> {
                    Toast.makeText(this,"Healthy", Toast.LENGTH_LONG).show()
                }

        }


    }
    private fun interpretBMI(bmi: Float, category: String) {
        val result: TextView = findViewById(R.id.result)

        when (category) {
            "Dewasa" -> {
                result.text = bmi.toString()
                when {
                    bmi < 18.5 -> {
                        Toast.makeText(this, "Underweight", Toast.LENGTH_LONG).show()
                    }
                    bmi in 18.5..25.0 -> {
                        Toast.makeText(this, "Normal", Toast.LENGTH_LONG).show()
                    }
                    bmi in 25.0..30.0 -> {
                        Toast.makeText(this, "Overweight", Toast.LENGTH_LONG).show()
                    }
                    else -> {
                        Toast.makeText(this, "Obese", Toast.LENGTH_LONG).show()
                    }
                }
            }
            "Anak - Anak" -> {
                result.text = bmi.toString()
                when {
                    bmi < 5 -> {
                        Toast.makeText(this, "Underweight", Toast.LENGTH_LONG).show()
                    }
                    bmi in 5.0..85.0 -> {
                        Toast.makeText(this, "Normal", Toast.LENGTH_LONG).show()
                    }
                    bmi in 85.0..95.0-> {
                        Toast.makeText(this, "Overweight", Toast.LENGTH_LONG).show()
                    }
                    bmi > 95 -> {
                        Toast.makeText(this, "Obese", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }



}