package com.example.appphytagoras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var editTextSisiA: EditText
    private lateinit var editTextSisiB: EditText
    private lateinit var tombolHitung: Button
    private lateinit var textViewHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen UI
        editTextSisiA = findViewById(R.id.editTextSideA)
        editTextSisiB = findViewById(R.id.editTextSideB)
        tombolHitung = findViewById(R.id.buttonCalculate)
        textViewHasil = findViewById(R.id.textViewResult)

        // Atur listener untuk tombol hitung
        tombolHitung.setOnClickListener {
            hitungSisiMiring()
        }
    }

    private fun hitungSisiMiring() {
        // Ambil nilai input
        val teksSisiA = editTextSisiA.text.toString()
        val teksSisiB = editTextSisiB.text.toString()

        // Validasi input
        if (teksSisiA.isEmpty() || teksSisiB.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai untuk kedua sisi", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val sisiA = teksSisiA.toDouble()
            val sisiB = teksSisiB.toDouble()

            // Cek apakah nilainya positif
            if (sisiA <= 0 || sisiB <= 0) {
                Toast.makeText(this, "Masukkan nilai yang positif", Toast.LENGTH_SHORT).show()
                return
            }

            // Hitung menggunakan rumus Pythagoras: c² = a² + b²
            val sisiMiring = sqrt(sisiA * sisiA + sisiB * sisiB)

            // Tampilkan hasil sebagai angka bulat jika hasilnya bilangan bulat
            val hasil = if (sisiMiring % 1 == 0.0) sisiMiring.toInt().toString() else String.format("%.2f", sisiMiring)
            textViewHasil.text = "Sisi miring (c) = $hasil"
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show()
        }
    }
}