package com.citigroup.calendario.AgregarEvento

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.citigroup.calendario.MainActivity
import com.citigroup.calendario.R

class Inscripcion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscripcion)

        val btnEnviar = findViewById<Button>(R.id.enviar)
        btnEnviar.setOnClickListener {navigateToPrincipal()}

        val btnCancelar = findViewById<TextView>(R.id.cancelar)
        btnCancelar.setOnClickListener {navigateToPrincipal()}
    }


    private fun navigateToPrincipal(){
        val intent = Intent(this, MainActivity:: class.java)
        startActivity(intent)
    }
}