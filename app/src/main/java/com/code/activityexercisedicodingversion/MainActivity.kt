package com.code.activityexercisedicodingversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /*
    companion atau objek teman
    digunakan untuk menyimpan konstanta atau metode yang dapat
    diakses dari kelas tersebut tanpa menginstansiasi
     */
    companion object{
        private const val STATE_RESULT = "state result"
    }


    private lateinit var edtWidth:EditText
    private lateinit var edtHeight:EditText
    private lateinit var edtLength:EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null){
            val result =savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }

    }

    override fun onClick(view: View?) {
        if(view?.id == R.id.btn_calculate){
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()
            var isEmptyField = false

            if(inputLength.isEmpty()){
                isEmptyField = true
                edtLength.error = "Field ini tidak boleh kosong"
            }
            if(inputWidth.isEmpty()){
                isEmptyField = true
                edtWidth.error = "Field ini tidak boleh kosong"
            }
            if(inputHeight.isEmpty()){
                isEmptyField = true
                edtHeight.error = "Field ini tidak boleh kosong"
            }
            if (!isEmptyField){
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
            }
        }

    }

    /*
    metode ini digunakan untuk menyimpan data ketika sautu aktivitas dihancurkan

     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }
}

