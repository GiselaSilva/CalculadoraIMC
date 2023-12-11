package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
        tvResult.text = result.toString()

        val classificao = if (result < 18.5f){
            "Abaixo do Peso"
        } else if (result in 18.5f..24.9f){ //o Android Studio sugeriu um range que simplifica o else if
            "Normal"
        } else if (result >24.9 && result <= 29.9f){ //aqui, ficou como tinhamos feito em aula
            "Sobrepeso"
        } else if (result >29.9 && result <=39.9f){
            "Obesidade"
        }else {
            "Obesidade Grave"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}